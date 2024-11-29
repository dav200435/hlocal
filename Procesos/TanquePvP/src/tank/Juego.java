package tank;

import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Battlefield battlefield = new Battlefield();

        inicializeTanks(battlefield);

        while (battlefield.isGameRunning()) {
            BattlefieldDisplay.displayBattlefield(battlefield);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Fin del juego.");
    }
    
    private static void inicializeTanks(Battlefield battlefield) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos tanques participarán?");
        int tankAmount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < tankAmount; i++) {
            System.out.println("Introduce el nombre del tanque " + (i + 1) + ":");
            String name = sc.nextLine();
            Tank tank = new Tank(name, battlefield);
            battlefield.addTank(tank);
            Thread t1 = new Thread(tank);
            t1.start();
        }
        sc.close();
    }
}
