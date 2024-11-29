package monaco;

import java.io.FileWriter;
import java.io.IOException;

public class GenerarAlumnoXML {
    public static void main(String[] args) {
        String[] modules = {
            "Acceso a Datos", 
            "Programación de servicios y procesos", 
            "Desarrollo de interfaces", 
            "Programación multimedia y dispositivos móviles", 
            "Sistemas de gestión empresarial", 
            "Empresa e iniciativa emprendedora"
        };
        
        boolean[] permiteFCT = {false, true, false, false, true, true};
        int[] horas = {6, 3, 6, 5, 5, 3};
        double[] notas = {8.45, 9.0, 8.0, 7.34, 8.2, 7.4};
        
        try {
            FileWriter writer = new FileWriter("alumno.xml");
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<modulos>\n");

            for (int i = 0; i < modules.length; i++) {
                writer.write("  <modulo horas=\"" + horas[i] + "\" permiteFCT=\"" + permiteFCT[i] + "\">\n");
                writer.write("    <nombre>" + modules[i] + "</nombre>\n");
                writer.write("    <nota>" + notas[i] + "</nota>\n");
                writer.write("  </modulo>\n");
            }

            writer.write("</modulos>");
            writer.close();
            System.out.println("El archivo alumno.xml se ha generado correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

