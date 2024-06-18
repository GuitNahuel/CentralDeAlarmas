package ar.unlam.edu.dominio;

public class Usuario {
	private String dni;
	private String nombre;

	public Usuario(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

}
