package hilosEjs;

public class Ej2 extends Thread{
	private String name;

	public Ej2(String name) {
		super();
		this.name=name;
	}
	
	@Override
	public void run() {
		for (int i = 0; i<11;i++) {
			System.out.println(this.name+" "+i);
			try {
				Thread.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Ej2 h1 = new Ej2("hilo1");
		Ej2 h2 = new Ej2("hilo2");
		Ej2 h3 = new Ej2("hilo3");
		
		h1.start();
		h2.start();
		h3.start();
	}
}