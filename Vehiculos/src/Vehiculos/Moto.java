package Vehiculos;

public class Moto extends Vehiculos {
	
	private int cilindrada;
	
	public Moto() {
		this.cilindrada=350;
	}
	
	public Moto(String matricula,String color,int cilindrada) {
		super(matricula,color);
		this.cilindrada = cilindrada;
	}
	
	public Moto(Moto copy) {
		this.matricula=copy.matricula;
		this.color=copy.color;
		this.cilindrada=copy.cilindrada;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "Moto [cilindrada=" + cilindrada + ", matricula=" + matricula + ", color=" + color + "]";
	}
}
