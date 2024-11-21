package hilosEjs;

public class Ej4Banco {
	private Double dinero;
	
	public Ej4Banco(Double dinero) {
		this.dinero = dinero;
	}
	
	public synchronized void retirar(Double cantidad){
		if (cantidad<=this.dinero) {
			this.dinero -=cantidad;
			System.out.println(this.dinero);
		}
	}
	
	public synchronized void ingresar(Double cantidad) {
			this.dinero +=cantidad;
			System.out.println(this.dinero);
	}
}
