package pdf;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import createDDBB.DBGenerator;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.List;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class GeneratePdf {
    public static void main(String[] args) {
        String dest = "example.pdf";
        String imageUrl = "https://media.giphy.com/media/IlyNN0Ledb5Fh1x68K/giphy.gif";
        String tempImagePath = "./src/main/resources/img/temp_image.gif";

        try {
            downloadImage(imageUrl, tempImagePath);

            PdfWriter writer = new PdfWriter(dest);

            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("¡Hola, este es un PDF generado en Java!"));
            document.add(new Paragraph("Segunda línea de un PDF"));

            ImageData imageData = ImageDataFactory.create(tempImagePath);
            Image img = new Image(imageData);
            img.scaleAbsolute(50, 50);
            String dbRoute = "./src/main/resources/miBaseDeDatos.db";
            DBGenerator db = new DBGenerator(dbRoute);
            db.limpiarDB("miTabla");
            db.crearTabla("miTabla");
            db.insertarDatos("miTabla", "Dato 1", 100.0);
            db.insertarDatos("miTabla", "Dato 2", 200.0);
            db.insertarDatos("miTabla", "Dato 3", 300.0);
            db.insertarDatos("miTabla", "Dato 4", 400.0);
            db.insertarDatos("miTabla", "Dato 5", 500.0);

            Table table = new Table(3);
            table.addCell("Nombre");
            table.addCell("Valor");
            table.addCell("Imagen");

            try (java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:sqlite:"+dbRoute);
                 java.sql.Statement stmt = connection.createStatement();
                 java.sql.ResultSet rs = stmt.executeQuery("SELECT * FROM miTabla")) {

                while (rs.next()) {
                    table.addCell(rs.getString("nombre"));
                    table.addCell(String.valueOf(rs.getDouble("valor")));
                    table.addCell(new Image(imageData).scaleAbsolute(50, 50));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            document.add(table);

            List list = new List();
            list.add("Elemento 1");
            list.add("Elemento 2");
            list.add("Elemento 3");
            document.add(list);

            document.close();

            System.out.println("PDF creado en: " + dest);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Files.deleteIfExists(Path.of(tempImagePath));
            } catch (Exception e) {
                System.err.println("No se pudo eliminar la imagen temporal: " + e.getMessage());
            }
        }
    }

    /**
     * Descarga una imagen desde un enlace y la guarda localmente.
     *
     * @param imageUrl  URL de la imagen
     * @param savePath  Ruta donde se guardará la imagen
     * @throws Exception Si ocurre un error durante la descarga
     */
    public static void downloadImage(String imageUrl, String savePath) throws Exception {
        try (InputStream in = new URL(imageUrl).openStream()) {
            Files.copy(in, Path.of(savePath), StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
