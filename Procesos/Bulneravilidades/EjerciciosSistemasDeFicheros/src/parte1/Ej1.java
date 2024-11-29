package parte1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ej1 {

    private File file;
    private FileReader fr;
    private BufferedReader br;

    public Ej1() {
        this.file = new File("file.txt");
        try {
            this.fr = new FileReader(this.file);
            this.br = new BufferedReader(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void countVocals() {
        int vocals = 0;
        String text;
        if (file.exists() && file.isFile()) {
        	
        	try {
	            while ((text = br.readLine()) != null) {
	                for (int i = 0; i < text.length(); i++) {
	                    char c = Character.toLowerCase(text.charAt(i));
	                    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
	                        vocals++;
	                    }
	                }
	            }
	            br.close();
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        	System.out.println("Hay "+vocals+" vocales");
        }else {
        	System.out.println("el fichero no existe");
        }
	}
}
