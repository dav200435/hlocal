package vehiculos;

public class Camion {
	private String color;
	private String modelo;
	private int numPlazas;
	private double peso;
	private double altura;
	
	public Camion() {
	
	}

	public Camion(String color, String modelo, int numPlazas, double peso, double altura) {
		this.color = color;
		this.modelo = modelo;
		this.numPlazas = numPlazas;
		this.peso = peso;
		this.altura = altura;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String meodelo) {
		this.modelo = meodelo;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Camion [color=" + color + ", modelo=" + modelo + ", numPlazas=" + numPlazas + ", peso=" + peso
				+ ", altura=" + altura + "]";
	}
	
	
}
