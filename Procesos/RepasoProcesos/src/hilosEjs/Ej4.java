package hilosEjs;

public class Ej4 extends Thread{

	private Ej4Banco banco;
	
	public Ej4(Ej4Banco banco) {
		super();
		this.banco = banco;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("empezando operaciones");
			this.banco.retirar(100.0);
			this.banco.ingresar(100.0);
			System.out.println("operaciones "+ (i+1) +" realizadoas");
			try {
				Thread.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Ej4Banco banco = new Ej4Banco(1000.0);
		Ej4 cli1 = new Ej4(banco);
		Ej4 cli2 = new Ej4(banco);
		Ej4 cli3 = new Ej4(banco);
		cli1.start();
		cli2.start();
		cli3.start();
	}
}


