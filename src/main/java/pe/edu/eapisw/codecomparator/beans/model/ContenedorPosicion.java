package pe.edu.eapisw.codecomparator.beans.model;

import java.util.Collection;

import pe.edu.eapisw.codecomparator.beans.json.Posicion;

public class ContenedorPosicion {
	private Collection<Posicion> posiciones;
	
	public ContenedorPosicion(){
		
	}

	public Collection<Posicion> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(Collection<Posicion> posiciones) {
		this.posiciones = posiciones;
	}
	
}
