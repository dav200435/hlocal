package almacenamientoJSONSegundaParte;

import org.json.JSONObject;

public class Tarea {
    private String titulo;
    private int prioridad;
    private boolean completada;

    public Tarea(String titulo, int prioridad, boolean completada) {
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.completada = completada;
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    // Método para convertir a JSON
    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        json.put("titulo", this.titulo);
        json.put("prioridad", this.prioridad);
        json.put("completada", this.completada);
        return json;
    }

    // Método para crear un objeto Tarea desde un JSON
    public static Tarea fromJSON(JSONObject json) {
        String titulo = json.getString("titulo");
        int prioridad = json.getInt("prioridad");
        boolean completada = json.getBoolean("completada");
        return new Tarea(titulo, prioridad, completada);
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "titulo='" + titulo + '\'' +
                ", prioridad=" + prioridad +
                ", completada=" + completada +
                '}';
    }
}
