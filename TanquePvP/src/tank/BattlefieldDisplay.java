package tank;

public class BattlefieldDisplay {

    private static final int FIELD_SIZE = 20;

    public static void displayBattlefield(Battlefield battlefield) {
        char[][] field = new char[FIELD_SIZE][FIELD_SIZE];

        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                field[i][j] = '.';
            }
        }

        for (Tank tank : battlefield.getTanks()) {
            int x = tank.getX();
            int y = tank.getY();
            if (tank.getHealth() > 0) {
                field[x][y] = tank.getName().charAt(0); 
            }
        }

        System.out.println("\nCampo de Batalla:");
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
