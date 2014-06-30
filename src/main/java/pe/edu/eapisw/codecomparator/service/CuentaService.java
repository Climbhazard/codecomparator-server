package pe.edu.eapisw.codecomparator.service;

import pe.edu.eapisw.codecomparator.beans.model.Docente;
import pe.edu.eapisw.codecomparator.beans.model.Usuario;

public interface CuentaService {
	public Usuario getUsuario();

	public Docente loginDocente(Usuario usuario);

	public void crearCuentaDocente(Usuario usuario);
}
