package funcional;

public class Cena {
    public static void main(String[] args) {
        int numeroFilosofos = 5;
        Filosofo[] filosofos = new Filosofo[numeroFilosofos];
        Tenedor[] tenedores = new Tenedor[numeroFilosofos];

        for (int i = 0; i < numeroFilosofos; i++) {
            tenedores[i] = new Tenedor();
        }

        for (int i = 0; i < numeroFilosofos; i++) {
            Tenedor tenedorIzquierdo = tenedores[i];
            Tenedor tenedorDerecho = tenedores[(i + 1) % numeroFilosofos];

            filosofos[i] = new Filosofo(i, tenedorIzquierdo, tenedorDerecho);
            filosofos[i].start();
        }
    }
}