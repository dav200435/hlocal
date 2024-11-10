package ejemplos;

public class Ejemplo1 extends Thread {
	public Ejemplo1(String name) {
		super(name);
	}
	
	public void run() {
		for (int i=0;i<30;i++) {
			System.out.println(this.getName() + " " + i);
//			try {
//			System.out.println("");
//				//	sleep((long) (Math.random()*1000));
//			} catch (Error e) {
//				e.printStackTrace();
//			}
		}
	}

}
