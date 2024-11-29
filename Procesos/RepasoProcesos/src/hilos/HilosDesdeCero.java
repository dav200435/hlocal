package hilos;

public class HilosDesdeCero extends Thread{
	private String name;

	public HilosDesdeCero(String name) {
		super();
		this.name=name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i<11;i++) {
			System.out.println(this.name+" "+i);
		}
	}
	
	public static void main(String[] args) {
		HilosDesdeCero h1 = new HilosDesdeCero("hilo1");
		HilosDesdeCero h2 = new HilosDesdeCero("hilo2");
		HilosDesdeCero h3 = new HilosDesdeCero("hilo3");
		
		h1.start();
		h2.start();
		h3.start();
	}
}