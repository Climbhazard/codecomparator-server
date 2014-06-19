package pe.edu.eapisw.codecomparator.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Clase que almacenara el contenido del proyecto fisico cargado al servidor
 * */
public class Proyecto implements Serializable {

	private static final long serialVersionUID = -9104261263964389144L;
	private String nombre;
	private Collection<Codigo> codigos = new ArrayList<Codigo>();
	private Collection<Paquete> paquetes = new ArrayList<Paquete>();

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Codigo> getCodigos() {
		return codigos;
	}

	public void setCodigos(Collection<Codigo> codigos) {
		this.codigos = codigos;
	}

	public Collection<Paquete> getPaquetes() {
		return paquetes;
	}

	public void setPackages(Collection<Paquete> paquetes) {
		this.paquetes = paquetes;
	}

	@Override
	public String toString() {
		return "Proyecto : [nombre : " + nombre
				+ ((codigos.isEmpty()) ? "" : "\n\tC\u00f3digos : " + codigos)
				+ ((paquetes.isEmpty()) ? "" : "\n\tPaquetes : " + paquetes)
				+ " ]";
	}
}
