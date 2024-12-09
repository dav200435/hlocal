package ficherosDeTexto;

public class main {
	public static void main(String[] args) {
		// TODO: Crear una instancia de GestionAlumnos para gestionar la lista de alumnos
		GestionAlumnos gestionAlumnos = new GestionAlumnos();

		// TODO: Agregar 5 alumnos a la lista 
		gestionAlumnos.agregarAlumno(new Alumno("Nahiara",21,"DAM",7.56));
		gestionAlumnos.agregarAlumno(new Alumno("Daniel",19,"DAM",6.4));
		gestionAlumnos.agregarAlumno(new Alumno("Mario",20,"DAM",7.2));
		gestionAlumnos.agregarAlumno(new Alumno("David",20,"DAM",0.01));
		gestionAlumnos.agregarAlumno(new Alumno("Pepe",90,"Gestion Empresarial",10.0));

		// TODO: Llamar al método exportarAlumnosAJson de la instancia gestionAlumnos para exportar la lista a un archivo JSON llamado "Alumnos.json"
		gestionAlumnos.exportarAlumnosJson("AlumnosJson.json");
    }
}