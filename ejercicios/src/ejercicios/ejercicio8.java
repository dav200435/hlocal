package ejercicios;
import java.util.Scanner;

public class ejercicio8 {
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Intruduce un numero referente a un mes: ");
    	int numMes = sc.nextInt();
    	switch (numMes){
    	
    	case 1:
    		System.out.print("El mes es enero y tiene 31 dias");
    		break;
    		
    	case 2:
    		System.out.print("El mes es febrero y tiene 28 o 29 dias dependiendo si el año es bisiesto o no");
    		break;
    		
    	case 3:
    		System.out.print("El mes es marzo y tiene 31 dias");
    		break;
    		
    	case 4:
    		System.out.print("El mes es abril y tiene 30 dias");
    		break;
    		
    	case 5:
    		System.out.print("El mes es mayo y tiene 31 dias");
    		break;
    		
    	case 6:
    		System.out.print("El mes es junio y tiene 30 dias");
    		break;
    		
    	case 7:
    		System.out.print("El mes es julio y tiene 31 dias");
    		break;
    		
    	case 8:
    		System.out.print("El mes es agosto y tiene 31 dias");
    		break;
    		
    	case 9:
    		System.out.print("El mes es septiembre y tiene 30 dias");
    		break;
    		
    	case 10:
    		System.out.print("El mes es octubre y tiene 31 dias");
    		break;
    		
    	case 11:
    		System.out.print("El mes es noviembre y tiene 30 dias");
    		break;
    		
    	case 12:
    		System.out.print("El mes es diciembre y tiene 31 dias");
    		break;
    		
    	default :
    		System.out.print("valor no reconocido");
    		break;
    	
    		}
	    }	
}
