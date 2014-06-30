package pe.edu.eapisw.codecomparator.beans.model;

import java.io.Serializable;

public class Alumno implements Serializable {

	private static final long serialVersionUID = -8483917387722442892L;
	private Integer n_alumno_id;
	private String t_codigo; // código del alumno
	private String t_nombre;
	private String t_apellido_paterno;
	private String t_apellido_materno;
	private Docente docente;

	public Integer getN_alumno_id() {
		return n_alumno_id;
	}

	public void setN_alumno_id(Integer n_alumno_id) {
		this.n_alumno_id = n_alumno_id;
	}

	public String getT_codigo() {
		return t_codigo;
	}

	public void setT_codigo(String t_codigo) {
		this.t_codigo = t_codigo;
	}

	public String getT_nombre() {
		return t_nombre;
	}

	public void setT_nombre(String t_nombre) {
		this.t_nombre = t_nombre;
	}

	public String getT_apellido_paterno() {
		return t_apellido_paterno;
	}

	public void setT_apellido_paterno(String t_apellido_paterno) {
		this.t_apellido_paterno = t_apellido_paterno;
	}

	public String getT_apellido_materno() {
		return t_apellido_materno;
	}

	public void setT_apellido_materno(String t_apellido_materno) {
		this.t_apellido_materno = t_apellido_materno;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}
