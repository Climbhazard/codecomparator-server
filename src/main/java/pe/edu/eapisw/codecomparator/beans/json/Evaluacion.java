package pe.edu.eapisw.codecomparator.beans.json;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import pe.edu.eapisw.codecomparator.beans.model.Docente;

public class Evaluacion implements Serializable {

	private static final long serialVersionUID = 3793765939640816920L;
	private Integer n_evaluacion_id;
	private String titulo;// en lugar de descripcion al momento de mostralo en
							// la interfaz
	private String descripcion;
	private String tiempo;// duración de la evaluación
	// private Date horaInicio;// eliminar
	// private Date horaFin;// eliminar
	private Date fechaRegistro;
	// private Curso curso;
	private String curso;
	private String grupo;
	private Docente docente;
	private Collection<Posicion> matriz;

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public Integer getN_evaluacion_id() {
		return n_evaluacion_id;
	}

	public void setN_evaluacion_id(Integer n_evaluacion_id) {
		this.n_evaluacion_id = n_evaluacion_id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// public Date getHoraInicio() {
	// return horaInicio;
	// }
	//
	// public void setHoraInicio(Date horaInicio) {
	// this.horaInicio = horaInicio;
	// }
	//
	// public Date getHoraFin() {
	// return horaFin;
	// }
	//
	// public void setHoraFin(Date horaFin) {
	// this.horaFin = horaFin;
	// }

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	// public Curso getCurso() {
	// return curso;
	// }
	//
	// public void setCurso(Curso curso) {
	// this.curso = curso;
	// }

	public Collection<Posicion> getMatriz() {
		return matriz;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setMatriz(Collection<Posicion> matriz) {
		this.matriz = matriz;
	}

}
