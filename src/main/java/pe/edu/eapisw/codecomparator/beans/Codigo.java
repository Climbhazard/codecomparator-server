package pe.edu.eapisw.codecomparator.beans;

//import java.io.File;
import java.io.Serializable;

public class Codigo implements Serializable {

	private static final long serialVersionUID = 4910922867942133113L;
	private String nombre;
	// private File file = null;
	private String contenido;
	private Double[] Q;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double[] getQ() {
		return Q;
	}

	public void setQ(Double[] q) {
		Q = q;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "Codigo { nombre : " + nombre + " }";
	}

}
