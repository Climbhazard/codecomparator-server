package pe.edu.eapisw.codecomparator.beans.json;

import java.io.Serializable;

import pe.edu.eapisw.codecomparator.beans.model.Alumno;

public class Posicion implements Serializable {

	private static final long serialVersionUID = -4370630856808226073L;
	private Alumno alumno;
	private Proyecto proyecto;

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}
