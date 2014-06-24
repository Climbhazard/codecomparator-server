package pe.edu.eapisw.codecomparator.service;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;

public interface UserService {
	public Usuario getUsuario();
	public Usuario loginDocente(Usuario usuario);
	public void crearCuentaDocente(Usuario usuario);
}
