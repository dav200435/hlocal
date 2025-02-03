package caracterDeslizado;

import java.util.Random;

public class Deslizador {
	
	private final static String ABECEDARIO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public Deslizador() {}

	public static String genera(String texto, int cantidad) {
	    char[] cadena = texto.toCharArray();
	    char[] devolver = new char[cadena.length];

	    for (int i = 0; i < cadena.length; i++) {
	        if (cadena[i] == ' ') {
	            devolver[i] = ' ';
	        } else {
	            int index = ABECEDARIO.indexOf(Character.toUpperCase(cadena[i]));

	            if (index != -1) {
	            	int newIndex = (index - cantidad) % ABECEDARIO.length();
	                if (newIndex < 0) {
	                    newIndex += ABECEDARIO.length();
	                }

	                char newChar = ABECEDARIO.charAt(newIndex);

	                // Preserve case
	                if (Character.isLowerCase(cadena[i])) {
	                    newChar = Character.toLowerCase(newChar);
	                }

	                devolver[i] = newChar;
	            } else {
	                devolver[i] = cadena[i];
	            }
	        }
	    }
	    return new String(devolver);
	}
	
	public static String desencriptar(String texto, int cantidad) {
	    char[] cadena = texto.toCharArray();
	    char[] devolver = new char[cadena.length];

	    for (int i = 0; i < cadena.length; i++) {
	        if (cadena[i] == ' ') {
	            devolver[i] = ' ';
	        } else {
	            int index = ABECEDARIO.indexOf(Character.toUpperCase(cadena[i]));

	            if (index != -1) {
	                int newIndex = (index + cantidad) % ABECEDARIO.length();
	                char newChar = ABECEDARIO.charAt(newIndex);
	                
	                if (Character.isLowerCase(cadena[i])) {
	                    newChar = Character.toLowerCase(newChar);
	                }

	                devolver[i] = newChar;
	            } else {
	                devolver[i] = cadena[i];
	            }
	        }
	    }
	    return new String(devolver);
	}
	
	public static void main (String[] args) {
		String texto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		int numero = random.nextInt(1,10);
		System.out.println(numero);
		String encriptado = Deslizador.genera(texto, numero);
		System.out.println(encriptado);
		System.out.println(Deslizador.desencriptar(encriptado, numero));
	}
}
