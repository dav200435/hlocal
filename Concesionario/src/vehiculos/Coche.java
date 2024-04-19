package vehiculos;

public class Coche {
	private String color;
	private String clase;
	private int numPlazas;
	private int potencia;
	private boolean estrellado;
	
	public Coche() {
		
	}
	
	public Coche(String color, String clase, int numPlazas, int potencia) {
		this.color = color;
		this.clase = clase;
		this.numPlazas = numPlazas;
		this.potencia = potencia;
		this.estrellado=false;
	}
	
	public boolean estrellar(String piloto) {
		if (piloto.equalsIgnoreCase("Mazepin")) {
			this.estrellado=true;
			System.out.println( "Hace spin ");
		}
		return this.estrellado;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public int getNumPlazas() {
		return numPlazas;
	}

	public void setNumPlazas(int numPlazas) {
		this.numPlazas = numPlazas;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	

	public boolean isEstrellado() {
		return estrellado;
	}

	public void setEstrellado(boolean estrellado) {
		this.estrellado = estrellado;
	}

	@Override
	public String toString() {
		return "Coche [color=" + color + ", clase=" + clase + ", numPlazas=" + numPlazas + ", potencia=" + potencia
				+ "]";
	}
	
}
