package Vehiculos;

public class Coche extends Vehiculos {
	private int puertas;
	
	public Coche() {
		this.puertas=350;
	}
	
	public Coche(String matricula,String color,int puertas) {
		super(matricula,color);
		this.puertas = puertas;
	}
	
	public Coche(Coche copy) {
		this.matricula=copy.matricula;
		this.color=copy.color;
		this.puertas=copy.puertas;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	@Override
	public String toString() {
		return "Coche [puertas=" + puertas + ", matricula=" + matricula + ", color=" + color + "]";
	}
}
