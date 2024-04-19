package entornos_grupal;

public class CuentaBancaria {

    private String titular1;
    private String titular2;
    private String dni;
    private double cantidad;
    
    public CuentaBancaria(String titular1, String dni) {
        this.titular1 = titular1;
        this.titular2 = "";
        this.dni = dni;
        this.cantidad = 0.0;
    }
    
    public CuentaBancaria(String titular1, String dni,String titular2,double cantidad) {
        this.titular1 = titular1;
        this.titular2 = titular2;
        this.dni = dni;
        this.cantidad = cantidad;
    }
    
    public CuentaBancaria(String titular1, String dni, double cantidad) {
        this.titular1 = titular1;
        this.titular2 = "";
        this.dni = dni;
        this.cantidad = cantidad;
    }
    
    public CuentaBancaria(String titular1, String dni,String titular2) {
        this.titular1 = titular1;
        this.titular2 = titular2;
        this.dni = dni;
        this.cantidad = 0.0;
    }
    
    public CuentaBancaria(CuentaBancaria c) {
        this.titular1 = c.titular1;
        this.titular2 = new String(c.titular2);
        this.dni = c.dni;
        this.cantidad = c.cantidad;
    }
    
    //getter titular1
    public String getTitular1(){
    	return titular1;
    }
    
  //Setter titular1
    public void setTitular1(String titular1){
    	this.titular1=titular1;
    }
  
    //getter titular2
    public String getTitular2(){
    	return titular2;
    }
  
    //Setter titular2
    public void setTitular2(String titular2){
    	this.titular2 = titular2;
    }
    
  //getter titular1
    public String getDNI(){
    	return dni;
    }
    
  //Setter titular1
    public void setDNI(String dni){
    	this.dni=dni;
    }
    
  //getter titular3
    public double getCantidad(){
    	return cantidad;
    }
    
  //Setter titular3
    public void setCantidad(double cantidad){
    	this.cantidad=cantidad;
    }
    
    public void ingresar(double cantidad){
		this.cantidad += cantidad;
	}
    		
    public void retirar( double cantidad){ 
    	this.cantidad -= cantidad;
	}

	/*@Override
	public String toString() {
		return "CuentaBancaria [titular1=" + titular1 + ", titular2=" + titular2 + ", dni=" + dni + ", cantidad="
				+ cantidad + "]";
	}
    */
    
}   
