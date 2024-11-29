package bloqueo;

public class FilosofoDeadlock {
	public static void main(String[] args) {
		Filosofo[] filosofos = new Filosofo[5];
		Tenedor[] tenedor = new Tenedor[5];
		for (int i=0; i<5;i++) {
			tenedor[i]=new Tenedor();
		}
		
		for (int i=0; i<5;i++) {
			Tenedor tenedorIz = tenedor[i];
			Tenedor tenedorDe = tenedor[(i+1)%5];
			filosofos[i] = new Filosofo(i+1,tenedorIz,tenedorDe);
			filosofos[i].start();
		}
	}
}
