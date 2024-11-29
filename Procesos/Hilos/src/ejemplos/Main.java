package ejemplos;

public class Main {
	
	private static void ejemplo1() {
		Ejemplo1 h1 = new Ejemplo1("hilo 1");
		Ejemplo1 h2 = new Ejemplo1("hilo 2");
		h1.setPriority(Thread.MIN_PRIORITY);
		h2.setPriority(Thread.MAX_PRIORITY);
		h1.start();
		h2.start();
	}
	
	private static void ejemplo2() {
		Circulo h1 = new Circulo("h1");
		Circulo h2 = new Circulo("h2");
	}

	public static void main(String[] args) {
//		ejemplo1();
//		System.out.println(" ");
//		System.out.println(" ");
//		System.out.println(" ");
//		System.out.println(" ");
//		System.out.println(" ");
//		System.out.println(" ");
		ejemplo2();
		
	}
}
