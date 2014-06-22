package pe.edu.eapisw.codecomparator.beans.model;

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

	@Override
	public boolean equals(Object anotherObject) {
		if (anotherObject instanceof Usuario) {
			if (((Usuario) anotherObject).getUsuario().equals(usuario)) {
				if (((Usuario) anotherObject).getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}

}
