package pe.edu.eapisw.codecomparator.beans.model;

import java.io.Serializable;

public class Curso implements Serializable {

	private static final long serialVersionUID = 7662375284771959577L;
	private Integer cursoId;
	private String nombre;
	// private Integer grupo;
	private String grupo;
	// private Collection<Docente> docentes;
	private Docente docente;

	public Integer getCursoId() {
		return cursoId;
	}

	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}