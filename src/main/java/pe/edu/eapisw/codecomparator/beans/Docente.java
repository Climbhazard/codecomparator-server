package pe.edu.eapisw.codecomparator.beans;

public class Docente extends Usuario {

	private static final long serialVersionUID = -9006610970991568315L;
	private String docenteId; // código del docente
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;

	public String getDocenteId() {
		return docenteId;
	}

	public void setDocenteId(String docenteId) {
		this.docenteId = docenteId;
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

}
