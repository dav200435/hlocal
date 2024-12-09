package almacenamientoJSON;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class NotificacionConfig {
	private String tipo;
    private String frecuencia;
    private List<String> preferencias;

    public NotificacionConfig(String tipo, String frecuencia, List<String> preferencias) {
        this.tipo = tipo;
        this.frecuencia = frecuencia;
        this.preferencias = preferencias;
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("tipo", tipo);
        json.put("frecuencia", frecuencia);
        json.put("preferencias", new JSONArray(preferencias));
        return json;
    }

    public static NotificacionConfig fromJSON(JSONObject json) {
        String tipo = json.getString("tipo");
        String frecuencia = json.getString("frecuencia");
        JSONArray preferenciasJSON = json.getJSONArray("preferencias");
        List<String> preferencias = new ArrayList<>();
        for (int i = 0; i < preferenciasJSON.length(); i++) {
            preferencias.add(preferenciasJSON.getString(i));
        }
        return new NotificacionConfig(tipo, frecuencia, preferencias);
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Frecuencia: " + frecuencia + ", Preferencias: " + preferencias;
    }
}
