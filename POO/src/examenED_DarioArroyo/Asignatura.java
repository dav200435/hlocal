package examenED_DarioArroyo;

public class Asignatura {
	private String nombre;
	private int numAlumnos;
	private String profesor;
	
	
	
	public Asignatura(String nombre,int numAlumnos,String profesor) {
		this.nombre = nombre;
		this.numAlumnos=numAlumnos;
		this.profesor=profesor;
		
	}
	
	public Asignatura(Asignatura a) {
		this.nombre = a.nombre;
		this.numAlumnos=a.numAlumnos;
		this.profesor=a.profesor;
	}

	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", numAlumnos=" + numAlumnos + ", profesor=" + profesor + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumAlumnos() {
		return numAlumnos;
	}

	public void setNumAlumnos(int numAlumnos) {
		this.numAlumnos = numAlumnos;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	
	public void alta() {
		numAlumnos+=1;
	}
	
	public void baja() {
		numAlumnos-=1;
	}
}
