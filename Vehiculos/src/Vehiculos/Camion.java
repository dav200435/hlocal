package Vehiculos;

public class Camion extends Vehiculos{
	private int cargaSoportada;
	
	public Camion() {
		this.cargaSoportada=350;
	}
	
	public Camion(String matricula,String color,int cargaSoportada) {
		super(matricula,color);
		this.cargaSoportada = cargaSoportada;
	}
	
	public Camion(Camion copy) {
		this.matricula=copy.matricula;
		this.color=copy.color;
		this.cargaSoportada=copy.cargaSoportada;
	}

	public int getCargaSoportada() {
		return cargaSoportada;
	}

	public void setCargaSoportada(int cargaSoportada) {
		this.cargaSoportada = cargaSoportada;
	}

	@Override
	public String toString() {
		return "Camion [cargaSoportada=" + cargaSoportada + ", matricula=" + matricula + ", color=" + color + "]";
	}
}
