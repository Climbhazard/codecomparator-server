package pe.edu.eapisw.codecomparator.beans.model;

import java.util.Collection;

import pe.edu.eapisw.codecomparator.beans.json.Posicion;

public class ContenedorPosicion {
	private Integer evaluacionId;
	private Integer tipoComparacion;
	private Collection<Posicion> posiciones;

	public ContenedorPosicion() {

	}

	public Integer getEvaluacionId() {
		return evaluacionId;
	}

	public void setEvaluacionId(Integer evaluacionId) {
		this.evaluacionId = evaluacionId;
	}

	public Integer getTipoComparacion() {
		return tipoComparacion;
	}

	public void setTipoComparacion(Integer tipoComparacion) {
		this.tipoComparacion = tipoComparacion;
	}

	public Collection<Posicion> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(Collection<Posicion> posiciones) {
		this.posiciones = posiciones;
	}

}
