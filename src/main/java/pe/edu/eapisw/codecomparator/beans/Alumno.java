package pe.edu.eapisw.codecomparator.beans;

import java.io.Serializable;

public class Alumno implements Serializable {

	private static final long serialVersionUID = -8483917387722442892L;
	private String alumnoId; // código del alumno
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;

	public String getAlumnoId() {
		return alumnoId;
	}

	public void setAlumnoId(String alumnoId) {
		this.alumnoId = alumnoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

}
