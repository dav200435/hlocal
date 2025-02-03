package cifrado;

public class Cifrador {
	private String alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ" + "0123456789 ";
	private String alfabetoCifrado;

	/*
	 * Dada una cadena como * "ABC" y un número (p.ej 2) * devuelve la cadena rotada
	 * a la izq * tantas veces como indique el numero, * en este caso "CAB"
	 */public String rotar(String cad, int numVeces) {
         char[] resultado = new char[cad.length()];
         for (int i = 0; i < cad.length(); i++) {
             int posParaExtraer = (i + numVeces) % cad.length();
             resultado[i] = cad.charAt(posParaExtraer);
         }
         return String.copyValueOf(resultado);
     }

	 public String cifrar(String mensaje, String clave) {
         StringBuilder mensajeCifrado = new StringBuilder();
         int desplazamiento = clave.length() % alfabeto.length();
         alfabetoCifrado = rotar(alfabeto, desplazamiento);

         for (char c : mensaje.toUpperCase().toCharArray()) {
             int index = alfabeto.indexOf(c);
             if (index != -1) {
                 mensajeCifrado.append(alfabetoCifrado.charAt(index));
             } else {
                 mensajeCifrado.append(c);
             }
         }
         return mensajeCifrado.toString();
     }

	public String descifrar(String mensajeCifrado, String clave) {
        StringBuilder mensajeDescifrado = new StringBuilder();
        int desplazamiento = clave.length() % alfabeto.length();
        alfabetoCifrado = rotar(alfabeto, desplazamiento);

        for (char c : mensajeCifrado.toUpperCase().toCharArray()) {
            int index = alfabetoCifrado.indexOf(c);
            if (index != -1) {
                mensajeDescifrado.append(alfabeto.charAt(index));
            } else {
                mensajeDescifrado.append(c);
            }
        }
        return mensajeDescifrado.toString();
    }

	public static void main(String[] args) {
		Cifrador c = new Cifrador();
		String cad = c.rotar("Hola Mundo", 325);
		System.out.println(cad);
	}
}