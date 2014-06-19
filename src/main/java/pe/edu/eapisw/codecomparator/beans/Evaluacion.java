package pe.edu.eapisw.codecomparator.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

public class Evaluacion implements Serializable {

	private static final long serialVersionUID = 3793765939640816920L;
	private String descripcion;
	private Date horaInicio;
	private Date horaFin;
	private Date fechaRegistro;
	private Curso curso;
	private Collection<Posicion> matriz;

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
