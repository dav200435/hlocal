package json;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerarXMLTrekking {
    public static void main(String[] args) {
        List<TrackPoint> trackPoints = new ArrayList<>();
        trackPoints.add(new TrackPoint(39.010751, -0.213694, 22.2999992370605, "Sat Sep 05 05:18:48 CEST 2020"));
        trackPoints.add(new TrackPoint(39.010733, -0.213690, 22.0, "Sat Sep 05 05:18:51 CEST 2020"));
        trackPoints.add(new TrackPoint(39.010707, -0.213681, 22.0, "Sat Sep 05 05:18:53 CEST 2020"));

        double elevMax = Double.MIN_VALUE;
        double elevMin = Double.MAX_VALUE;
        for (TrackPoint tp : trackPoints) {
            if (tp.getEle() > elevMax) elevMax = tp.getEle();
            if (tp.getEle() < elevMin) elevMin = tp.getEle();
        }

        double totalDistance = 0;
        double lapDistance = 0;
        int lapCount = 1;
        TrackPoint lastPoint = trackPoints.get(0);

        System.out.println("Elevación máxima: " + elevMax + " m");
        System.out.println("Elevación mínima: " + elevMin + " m");

        for (int i = 1; i < trackPoints.size(); i++) {
            TrackPoint currentPoint = trackPoints.get(i);
            lapDistance += lastPoint.distanceTo(currentPoint);
            totalDistance += lastPoint.distanceTo(currentPoint);

            if (lapDistance >= 1000) {
                System.out.println("Lap " + lapCount + ", 1000 m efectuada en " + currentPoint.getTime());
                lapDistance = 0;
                lapCount++;
            }

            lastPoint = currentPoint;
        }

        try (FileWriter file = new FileWriter("ruta.xml")) {
            file.write(generarXML(trackPoints));
            System.out.println("Archivo XML generado en ruta.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String generarXML(List<TrackPoint> trackPoints) {
        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n");
        xml.append("<tr>\n");
        xml.append("  <name>Ruta de la Penya Roja</name>\n");
        xml.append("  <date>Sat Sep 05 05:18:48 CEST 2020</date>\n");
        xml.append("  <trkPoints>\n");

        for (TrackPoint tp : trackPoints) {
            xml.append("    <trkpt lat=\"").append(tp.getLat()).append("\" lon=\"").append(tp.getLng()).append("\">\n");
            xml.append("      <ele>").append(tp.getEle()).append("</ele>\n");
            xml.append("      <time>").append(tp.getTime()).append("</time>\n");
            xml.append("    </trkpt>\n");
        }

        xml.append("  </trkPoints>\n");
        xml.append("</tr>");
        return xml.toString();
    }
}
