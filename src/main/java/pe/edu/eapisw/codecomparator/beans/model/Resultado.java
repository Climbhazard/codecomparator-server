package pe.edu.eapisw.codecomparator.beans.model;

import java.io.Serializable;

public class Resultado implements Serializable {

	private static final long serialVersionUID = -7925312610348273400L;
	private Integer resultadoId;
	private Comparacion comparacion;
	private Double porcentajeTotal; // FDTW
	// private String clasesSimilares;
	private String primero;
	private String segundo;

	public Integer getResultadoId() {
		return resultadoId;
	}

	public void setResultadoId(Integer resultadoId) {
		this.resultadoId = resultadoId;
	}

	public Comparacion getComparacion() {
		return comparacion;
	}

	public void setComparacion(Comparacion comparacion) {
		this.comparacion = comparacion;
	}

	public Double getPorcentajeTotal() {
		return porcentajeTotal;
	}

	public void setPorcentajeTotal(Double porcentajeTotal) {
		this.porcentajeTotal = porcentajeTotal;
	}

	public String getPrimero() {
		return primero;
	}

	public void setPrimero(String primero) {
		this.primero = primero;
	}

	public String getSegundo() {
		return segundo;
	}

	public void setSegundo(String segundo) {
		this.segundo = segundo;
	}

	// public String getClasesSimilares() {
	// return clasesSimilares;
	// }
	//
	// public void setClasesSimilares(String clasesSimilares) {
	// this.clasesSimilares = clasesSimilares;
	// }

}
