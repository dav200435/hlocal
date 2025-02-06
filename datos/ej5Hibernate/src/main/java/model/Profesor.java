package model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesor;

    private String nombre;

    @ManyToMany
    @JoinTable(
        name = "Docencia",
        joinColumns = @JoinColumn(name = "idProfesor"),
        inverseJoinColumns = @JoinColumn(name = "idModulo")
    )
    private List<Modulo> modulos;

	public Long getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}
    
}
