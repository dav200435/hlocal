package ejemplos;

public class Circulo implements Runnable {
	private Thread miHilo;
	
	public Circulo(String str) {
		this.miHilo = new Thread(this, str);
		this.miHilo.start();
		
	}
	public void run() {
		for (int i=0;i<30;i++) {
			System.out.println(this.miHilo.getName() + " " + i);
		}
	}
	
}
