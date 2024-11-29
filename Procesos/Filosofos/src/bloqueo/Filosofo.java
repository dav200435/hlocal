package bloqueo;

public class Filosofo extends Thread{
	private int id;
	private Tenedor tenedorI;
	private Tenedor tenedorD;
	public Filosofo(int id, Tenedor tenedorI, Tenedor tenedorD) {
		this.id = id;
		this.tenedorI=tenedorI;
		this.tenedorD=tenedorD;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				pensar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tomarTenedores();
			try {
				comer();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			soltarTenedores();
		}
	}
	
	public void pensar() throws InterruptedException {
		System.out.println("                      (");
		System.out.println("                     (  ) (");
		System.out.println("                      )    )");
		System.out.println("         |||||||     (  ( (");
		System.out.println("        ( O   O )        )");
		System.out.println(" ____oOO___(_)___OOo____(");
		System.out.println("(_______________________)");
		System.out.println("           JOINT "+this.id);
		Thread.sleep((long) Math.random()*1000);
	}
	
	private void tomarTenedores() {
		System.out.println("filosofo "+this.id+" esta intentando coger tenedores");
		synchronized (tenedorI) {
			System.out.println("filosofo "+this.id+" ha cogido tenedor izquierdo");
			System.out.println("filosofo "+this.id+" esta intentando coger tenedor derecho");
			synchronized (tenedorD) {
				System.out.println("filosofo "+this.id+" ha cogido tenedor izquierdo");
			}
		}
	}
	
	private void comer() throws InterruptedException {
		System.out.println("Filosofo "+this.id+" esta comiendo");
		Thread.sleep((long) Math.random()*1000);
	}
	
	private void soltarTenedores() {
		System.out.println("Filosofo "+this.id+" ha soltado los tenedores");
	}
}
