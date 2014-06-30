package pe.edu.eapisw.codecomparator.beans.model;

import java.util.Collection;

public class Docente extends Usuario {

	private static final long serialVersionUID = -9006610970991568315L;
	private String docenteId; // código del docente
	private String codigo;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Collection<Curso> cursos;
	private Collection<Alumno> alumnos;

	public String getDocenteId() {
		return docenteId;
	}

	public void setDocenteId(String docenteId) {
		this.docenteId = docenteId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Collection<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Collection<Curso> cursos) {
		this.cursos = cursos;
	}

	public Collection<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Collection<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}
