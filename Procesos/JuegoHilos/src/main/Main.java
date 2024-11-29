package main;

import java.util.Scanner;

import juego.CarreraDeBuses;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("introduce numero de participantes");
		int numeroDeBuses = sc.nextInt();
        CarreraDeBuses carrera = new CarreraDeBuses(numeroDeBuses);
        carrera.iniciarParticipantes();
        carrera.start();
	}

}
