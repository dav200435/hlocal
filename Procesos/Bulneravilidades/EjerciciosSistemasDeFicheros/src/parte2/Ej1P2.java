package parte2;

import java.io.File;
import java.util.ArrayList;

public class Ej1P2 {
	private File file;

    public Ej1P2(String ruta) {
        this.file = new File(ruta);
    }

    public void data() {
    	long freeFinal = 0;
    	long usableFinal = 0;
    	long totalFinal = 0;

        if (this.file.exists()) {
        	ArrayList<Long> list = new ArrayList<>();
            list.add(this.file.getFreeSpace());
            list.add(this.file.getUsableSpace());
            list.add(this.file.getTotalSpace());
            
            freeFinal = list.get(0) / (1024*1024*1024);
            usableFinal = list.get(1) / (1024*1024*1024);
            totalFinal = list.get(2) / (1024*1024*1024);
            
            System.out.println("Espacio libre=" + freeFinal + " GB");
            System.out.println("Espacio usable=" + usableFinal + " GB");
            System.out.println("Espacio total=" + totalFinal + " GB");
            System.out.println("Es oculto=" + this.file.isHidden());
        } else {
            System.out.println("La ruta no existe.");
        }
    }
}
