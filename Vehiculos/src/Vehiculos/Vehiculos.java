package Vehiculos;

public class Vehiculos {
	protected String matricula;
	protected String color;
	
	protected Vehiculos() {
		this.matricula = "0000ABC";
		this.color = "negro";
	}
	
	protected Vehiculos(String matricula,String color) {
		this.matricula = matricula;
		this.color = color;
	}
	
	protected Vehiculos(Vehiculos copy) {
		this.matricula = copy.matricula;
		this.color = copy.color;
	}

	protected String getMatricula() {
		return matricula;
	}

	protected void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	protected String getColor() {
		return color;
	}

	protected void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehiculos [matricula=" + matricula + ", color=" + color + "]";
	}
}
