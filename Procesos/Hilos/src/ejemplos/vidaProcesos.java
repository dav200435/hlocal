package ejemplos;

public class vidaProcesos implements Runnable {
	
	public void run () {
		try {
			Thread.sleep(1000);
			synchronized(this) {
				wait(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException {
		Thread h1 = new Thread(new vidaProcesos());
		h1.start();
		System.out.println("estado: " + h1.getState());
		Thread.sleep(500);
		System.out.println("estado: " + h1.getState());
		Thread.sleep(1000);
		System.out.println("estado: " + h1.getState());
		h1.join();
		System.out.println("estado: " + h1.getState());
	}
}
