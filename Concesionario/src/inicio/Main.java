package inicio;
import vehiculos.Coche;
import vehiculos.Moto;
import java.util.Scanner;
import vehiculos.Camion;
import vehiculos.Moto;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		String piloto;
//		boolean salir = false;
//		Coche coche1 = new Coche("Rojo","Turismo",5,80);
//		Coche coche2 = new Coche("Rojo","Turismo",5,200);
//		Coche coche3 = new Coche("Rojo","Turismo",5,351);
		
//		do {
//			System.out.println("¿Quien conduce?");
//			piloto=sc.nextLine();
//			coche1.estrellar(piloto);
//			System.out.println("\n");
//			if (coche1.isEstrellado()) {
//				salir=true;
//			}else if(piloto.equalsIgnoreCase("salir")){
//				salir=true;
//			}
//		}while(!salir);
//		System.out.println("Saliendo...");
//		Camion camion1 = new Camion("Blanco","gama FH de Volvo",3,3567,340);
		
//		System.out.println(coche1);
//		System.out.println("Atributos= color= "+coche1.getColor()+" clase="+coche1.getClase()+" numero de plazas= "+coche1.getNumPlazas()+" Potencia= "+coche1.getPotencia());
//	
//		System.out.println(camion1);
//		System.out.println("Atributos: color="+camion1.getColor()+" Modelo="+camion1.getModelo()+" plazas"+camion1.getNumPlazas()+" modelo= "+camion1.getModelo()+"altura="+camion1.getAltura());
	
		Moto moto1 = new Moto();
		boolean salir =false;
		int opcion;
		do {
			System.out.println("-----------------------------------------------------");
			System.out.println("1. Calcular consumo medio");
			System.out.println("2. repostar");
			System.out.println("3. ver gasolina restante y el maximo del deposito");
			System.out.println("4. Salir");
			System.out.println("-----------------------------------------------------");
			System.out.println("¿Que desea hacer?");
			opcion = sc.nextInt();
			switch (opcion) {
			case 1: {
				System.out.println("Inserta Kilometros realizados");
				float kilometros = sc.nextInt();
				System.out.println("Inserta combustible gastado");
				float combustible = sc.nextInt();
				moto1.consumoMedio(kilometros, combustible);
				break;
			}
			case 2: {
				int gasolina;
				System.out.println("¿Cuanto carburante desea repostar?");
				gasolina = sc.nextInt();
				moto1.repostar(gasolina); 
				break;
			}
			case 3: {
				System.out.println("Gasolina restante: "+moto1.getGasolina());
				System.out.println("Tamaño tanque (litros): "+moto1.getTanque());
				break;
			}
			case 4: {
				salir = true;
				System.out.println("Hasta otra");
				break;
			}
			default:
				System.out.println("Valor inesperado: " + opcion);
			}
		}while(!salir);
		sc.close();
	}
}
