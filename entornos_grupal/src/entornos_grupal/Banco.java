package entornos_grupal;

import java.util.Scanner;

public class Banco {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//System.out.println("¿Cuanto quiere ingresar?");
		CuentaBancaria dani =new CuentaBancaria("daniel","555555555Q",50);
		//CuentaBancaria angel=new CuentaBancaria("angel","deivid","444444444R",-500000);
		/**System.out.println(dani.getCantidad());
		int cantidad = sc.nextInt();
		if (cantidad>=0){
			dani.ingresar(cantidad);
		}else {
			System.out.print("Cantidad Invalida");
		}
		System.out.println("cantidad a retirar: ");
		System.out.println(dani.getCantidad());
		int retirar = sc.nextInt();
		if (retirar<=dani.getCantidad()) {
			dani.retirar(retirar);
		}else {
			System.out.println("No dispone de tanto credito");
		}
		System.out.print(dani.getCantidad());*/
		//dani.setTitular2("Mario");
		//System.out.println(dani.getTitular2());
		System.out.println(dani.getCantidad());
		//dani = angel;
		CuentaBancaria angel=new CuentaBancaria(dani);
		System.out.println(dani);
		System.out.println(angel);
		dani.setCantidad(75);
	}
}
