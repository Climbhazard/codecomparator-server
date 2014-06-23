package pe.edu.eapisw.codecomparator.persistence;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;

public interface UserMapper {

	public Usuario loginDocente(String username, String password);

}
