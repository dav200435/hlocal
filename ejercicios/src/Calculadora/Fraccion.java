package Calculadora;

public class Fraccion {
	int numerador1;
    int denominador1;
    int numerador2;
    int denominador2;
	String operacion;
	
	public Fraccion(){
		this.numerador1=0;
		this.numerador2=0;
		this.denominador1=0;
		this.denominador2=0;
		this.operacion=null;
	}
	public Fraccion(int num1,int den1,int num2,int den2,String operation){
		this.numerador1=num1;
		this.numerador2=num2;
		this.denominador1=den1;
		this.denominador2=den2;
		this.operacion=operation;
	}
	public void suma() {
		int Numerador = (this.numerador1 * this.denominador2) + (this.numerador2 * this.denominador1);
        int Denominador = this.denominador1 * this.denominador2;
        System.out.println(Numerador);
        System.out.println("-");
        System.out.println(Denominador);
	}
	public void resta() {
		int Numerador = (numerador1 * denominador2) - (numerador2 * denominador1);
        int Denominador = denominador1 * denominador2;
        System.out.println(Numerador);
        System.out.println("-");
        System.out.println(Denominador);
	}
	public void multiplicacion() {
		int Numerador = numerador1 * numerador2;
        int Denominador = denominador1 * denominador2;
        System.out.println(Numerador);
        System.out.println("-");
        System.out.println(Denominador);
	}
	public void division() {
		int Numerador = numerador1 * denominador2;
        int Denominador = denominador1 * numerador2;
        System.out.println(Numerador);
        System.out.println("-");
        System.out.println(Denominador);
	}
}
