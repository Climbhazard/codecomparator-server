package pe.edu.eapisw.codecomparator.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Paquete implements Serializable {

	private static final long serialVersionUID = -4843115943266287488L;
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
		return "\nPaquete : (nombre : "
				+ nombre
				+ ((codigos.isEmpty()) ? "" : ", C\u00f3digos<" + codigos.size() + "> : "
						+ codigos)
				+ ((paquetes.isEmpty()) ? "" : ", Paquetes<" + paquetes.size()
						+ "> : \n" + paquetes) + " )";
	}
}
