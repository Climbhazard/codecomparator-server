package pe.edu.eapisw.codecomparator.beans.json;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import pe.edu.eapisw.codecomparator.beans.model.Curso;
import pe.edu.eapisw.codecomparator.beans.model.Docente;

public class Evaluacion implements Serializable {

	private static final long serialVersionUID = 3793765939640816920L;
	private Integer evaluacionId;
	private String titulo;// en lugar de descripcion al momento de mostralo en
							// la interfaz
	private String descripcion;
	private String tiempo;// duración de la evaluación
	private String grupo;
	private Date fechaRegistro;
	private Curso curso;
	private Docente docente;
	private Collection<Posicion> matriz;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getEvaluacionId() {
		return evaluacionId;
	}

	public void setEvaluacionId(Integer evaluacionId) {
		this.evaluacionId = evaluacionId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Collection<Posicion> getMatriz() {
		return matriz;
	}

	public void setMatriz(Collection<Posicion> matriz) {
		this.matriz = matriz;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
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
