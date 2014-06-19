package pe.edu.eapisw.codecomparator.beans;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 7745777303227616952L;
	private String usuario;
	private String password;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
