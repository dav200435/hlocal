package json;

public class AlumnoTel {
    private Long idAlumno;
    private String nombre;
    private int edad;
    private boolean repetidor;
    private String[] telefonos;

    public AlumnoTel(Long idAlumno, String nombre, int edad, boolean repetidor, String[] telefonos) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.edad = edad;
        this.repetidor = repetidor;
        this.telefonos = telefonos;
    }

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isRepetidor() {
		return repetidor;
	}

	public void setRepetidor(boolean repetidor) {
		this.repetidor = repetidor;
	}

	public String[] getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(String[] telefonos) {
		this.telefonos = telefonos;
	}


}
