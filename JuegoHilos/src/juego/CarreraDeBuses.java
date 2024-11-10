package juego;

import java.util.ArrayList;
import java.util.List;

public class CarreraDeBuses extends Thread {
    private static final int META = 100;
    private int participantes;
    private List<Bus> buses;

    public CarreraDeBuses(int participantes) {
        this.participantes = participantes;
        this.buses = new ArrayList<>(participantes);
    }

    public void iniciarParticipantes() {
        for (int i = 0; i < this.participantes; i++) {
            Bus bus = new Bus("Bus " + (i + 1));
            buses.add(bus);
            bus.start();
        }
    }

    public void run() {
        for (Bus bus : buses) {
            try {
                bus.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("La carrera ha terminado!");
    }

    public static void main(String[] args) {
        int numeroDeBuses = 5;
        CarreraDeBuses carrera = new CarreraDeBuses(numeroDeBuses);
        carrera.iniciarParticipantes();
        carrera.start();
    }

	public int getParticipantes() {
		return participantes;
	}

	public void setParticipantes(int participantes) {
		this.participantes = participantes;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public static int getMeta() {
		return META;
	}
    
    
}