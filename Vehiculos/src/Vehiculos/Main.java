package Vehiculos;

public class Main {

	public static void main(String[] args) {
		Vehiculos generico = new Vehiculos();
		Vehiculos generico1 = new Vehiculos("1234DEF","azul");
		Vehiculos genericoCopia = new Vehiculos(generico1);
		Moto Ducatti = new Moto();
		Moto Ducatti1 = new Moto("567FRT","Rojo",700);
		Moto DucattiCopia = new Moto(Ducatti1);
		Coche Ford= new Coche();
		Coche Ford1= new Coche("4562HYF","Verde",5);
		Coche FordCopia= new Coche(Ford1);
		Camion Volvo= new Camion();
		Camion Volvo1= new Camion("6481GTR","Naranja",5400);
		Camion VolvoCopia= new Camion(Volvo1);
		System.out.println(generico.toString());
		System.out.println(generico1.toString());
		System.out.println(genericoCopia.toString());
		System.out.println(Ducatti.toString());
		System.out.println(Ducatti1.toString());
		System.out.println(DucattiCopia.toString());
		System.out.println(Ford.toString());
		System.out.println(Ford1.toString());
		System.out.println(FordCopia.toString());
		System.out.println(Volvo.toString());
		System.out.println(Volvo1.toString());
		System.out.println(VolvoCopia.toString());
		
		System.out.println(Volvo.getMatricula());
	}
}