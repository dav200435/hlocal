package vehiculos;

public class Moto extends Vehiculo{
	private int tanque;
	private float gasolina;
	private float consumo;
	private String modelo;
	private static int base=100;
	
	public Moto(){
	}
	
	public Moto(int tanque, float gasolina, float consumo, String modelo) {
		super();
		this.tanque = tanque;
		this.gasolina = gasolina;
		this.consumo = consumo;
		this.modelo = modelo;
	}

	public void consumoMedio(float kilometros, float combustible){
		if (this.gasolina>=combustible) {
			this.consumo = combustible/kilometros*base;
			System.out.println("El consumo es: "+this.consumo);
			this.gasolina=this.gasolina-combustible;
		}else{
			System.out.println("No dispones de tanto combustible");
		}
	}
	
	public void repostar(int cantidad) {
		if (cantidad + gasolina <= tanque) {
			gasolina = gasolina+cantidad;
		}else {
			float restante = this.tanque-this.gasolina;
			System.out.println("Tanque insuficiente "+restante+" litros restantes del taque");
		}
	}

	public int getTanque() {
		return tanque;
	}

	public void setTanque(int tanque) {
		this.tanque = tanque;
	}

	public float getGasolina() {
		return gasolina;
	}

	public void setGasolina(float gasolina) {
		this.gasolina = gasolina;
	}

	public float getConsumo() {
		return consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "color=" + getColor()+ ", modelo=" + modelo + ", tanque=" + tanque + ", gasolina=" + gasolina + ", consumo=" + consumo;
	}
	
}
