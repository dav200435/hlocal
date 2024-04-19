package enums;

public enum Color {
	AZUL("azul"),
    ROJO("rojo"),
    VERDE("verde"),
    MORADO("morado"),
    NEGRO("negro"),
    ROSA("rosa");
	
	private String traduccion;
	
	Color(String color) {
        this.traduccion= color;
    }

    public String getTraduccion() {
        return traduccion;
    }
}