package juego;

import java.util.Random;

class Bus extends Thread {
    private String nombre;
    private int posicion;

    public Bus(String nombre) {
        this.nombre = nombre;
        this.posicion = 0;
    }

    public void run() {
        Random random = new Random();
        while (posicion < CarreraDeBuses.getMeta()) {
            try {
                int avance = random.nextInt(10) + 1;
                posicion += avance;
                System.out.println(nombre + " ha avanzado a la posición: " + posicion);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " ha llegado a la META!");
    }
}