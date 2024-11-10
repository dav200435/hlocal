package json;
import org.json.JSONObject;

public class TrackPoint {
    private double lat;
    private double lng;
    private double ele;
    private String time;

    public TrackPoint(double lat, double lng, double ele, String time) {
        this.lat = lat;
        this.lng = lng;
        this.ele = ele;
        this.time = time;
    }

    public double getLat() { return lat; }
    public double getLng() { return lng; }
    public double getEle() { return ele; }
    public String getTime() { return time; }

    public double distanceTo(TrackPoint other) {
        double R = 6371000;
        double dLat = Math.toRadians(other.lat - this.lat);
        double dLng = Math.toRadians(other.lng - this.lng);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(this.lat)) * Math.cos(Math.toRadians(other.lat)) *
                   Math.sin(dLng / 2) * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
