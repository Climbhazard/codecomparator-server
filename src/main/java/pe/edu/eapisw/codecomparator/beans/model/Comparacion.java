package pe.edu.eapisw.codecomparator.beans.model;

import java.io.Serializable;

import pe.edu.eapisw.codecomparator.beans.json.Evaluacion;

public class Comparacion implements Serializable {

	private static final long serialVersionUID = -2727664758882609117L;
	private Integer comparacionId;
	private String descripcion;
	private int tipoComparacion;
	private Evaluacion evaluacion;
	private Alumno alumnoComparado; // contra el que se va a comparar
	private Alumno alumnoAComparar;

	public Integer getComparacionId() {
		return comparacionId;
	}

	public void setComparacionId(Integer comparacionId) {
		this.comparacionId = comparacionId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTipoComparacion() {
		return tipoComparacion;
	}

	public void setTipoComparacion(int tipoComparacion) {
		this.tipoComparacion = tipoComparacion;
	}

	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Alumno getAlumnoComparado() {
		return alumnoComparado;
	}

	public void setAlumnoComparado(Alumno alumnoComparado) {
		this.alumnoComparado = alumnoComparado;
	}

	public Alumno getAlumnoAComparar() {
		return alumnoAComparar;
	}

	public void setAlumnoAComparar(Alumno alumnoAComparar) {
		this.alumnoAComparar = alumnoAComparar;
	}

}
