package json;

import java.io.FileWriter;
import java.io.IOException;

public class GenerarJSON {
    public static void main(String[] args) {
        AlumnoTel al1 = new AlumnoTel(1000L, "Jose Andres Perez", 22, false, new String[]{"222333444", "555666777", "888999000"});
        AlumnoTel al2 = new AlumnoTel(1001L, "Ana Sanchis Cabanilles", 21, false, new String[]{"222333444", "555666777", "888999000", "333421039"});
        AlumnoTel al3 = new AlumnoTel(1002L, "Aina Gomes Pons", 23, true, new String[]{});
        AlumnoTel al4 = new AlumnoTel(10031L, "Ainara Gabaldón Estruch", 24, false, new String[]{"222111214", "515626677"});

        AlumnoTel[] alumnos = {al1, al2, al3, al4};

        try (FileWriter file = new FileWriter("alumnos.json")) {
            file.write(alumnosToJson(alumnos));
            System.out.println("Datos de los alumnos guardados en alumnos.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String alumnosToJson(AlumnoTel[] alumnos) {
        StringBuilder json = new StringBuilder();
        json.append("[\n");

        for (int i = 0; i < alumnos.length; i++) {
            AlumnoTel alumno = alumnos[i];
            json.append("  {\n");
            json.append("    \"idAlumno\": ").append(alumno.getIdAlumno()).append(",\n");
            json.append("    \"nombre\": \"").append(alumno.getNombre()).append("\",\n");
            json.append("    \"edad\": ").append(alumno.getEdad()).append(",\n");
            json.append("    \"repetidor\": ").append(alumno.isRepetidor()).append(",\n");
            json.append("    \"telefonos\": [");

            String[] telefonos = alumno.getTelefonos();
            for (int j = 0; j < telefonos.length; j++) {
                json.append("\"").append(telefonos[j]).append("\"");
                if (j < telefonos.length - 1) json.append(", ");
            }
            json.append("]\n");

            json.append("  }");
            if (i < alumnos.length - 1) json.append(",");
            json.append("\n");
        }

        json.append("]");
        return json.toString();
    }
}
