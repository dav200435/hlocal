package monaco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerMonaco {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Monaco2017.xml"));
            String line;
            String nombre = "", apellido = "", escuderia = "", parrilla = "", posicion = "", laps = "", tiempo = "", vueltaRapida = "", totalMillis = "";

            System.out.println("Resultado de carrera:");
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("<GivenName>")) {
                    nombre = extractValue(line, "GivenName");
                } else if (line.startsWith("<FamilyName>")) {
                    apellido = extractValue(line, "FamilyName");
                } else if (line.startsWith("<Name>")) {
                    escuderia = extractValue(line, "Name");
                } else if (line.startsWith("<Grid>")) {
                    parrilla = extractValue(line, "Grid");
                } else if (line.startsWith("<position>")) {
                    posicion = extractValue(line, "position");
                } else if (line.startsWith("<Laps>")) {
                    laps = extractValue(line, "Laps");
                } else if (line.startsWith("<Time ")) {
                    totalMillis = extractAttribute(line, "millis");
                    tiempo = extractValue(line, "Time");
                } else if (line.startsWith("<FastestLap ")) {
                    vueltaRapida = extractAttribute(line, "rank");
                } else if (line.startsWith("</result>")) {
                    System.out.println(nombre + " " + apellido + " conduciendo un " + escuderia);
                    System.out.println("Parte de la posicion " + parrilla + " y termina en la " + posicion);
                    System.out.println("Ha completado " + laps + " vueltas tardando " + totalMillis + " milisegundos");
                    System.out.println("Su clasificacion en vuelta rapida personal - " + vueltaRapida);
                    System.out.println();
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractValue(String line, String tagName) {
        return line.substring(line.indexOf("<" + tagName + ">") + tagName.length() + 2,
                line.indexOf("</" + tagName + ">"));
    }

    private static String extractAttribute(String line, String attributeName) {
        int startIndex = line.indexOf(attributeName + "=\"") + attributeName.length() + 2;
        int endIndex = line.indexOf("\"", startIndex);
        return line.substring(startIndex, endIndex);
    }
}
