package pe.edu.eapisw.codecomparator.beans.json;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import pe.edu.eapisw.codecomparator.beans.model.Curso;

public class Evaluacion implements Serializable {

	private static final long serialVersionUID = 3793765939640816920L;
	private Integer evaluacionId;
	private String titulo;// en lugar de descripcion al momento de mostralo en
							// la interfaz
	private String descripcion;
	private String duracion;// duración de la evaluación
	private Date horaInicio;// eliminar
	private Date horaFin;// eliminar
	private Date fechaRegistro;
	private Curso curso;
	private Collection<Posicion> matriz;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
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

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
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

}
