package pe.edu.eapisw.codecomparator.service.impl;

import org.springframework.stereotype.Service;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;
import pe.edu.eapisw.codecomparator.service.UserService;

@Service("usuarioService")
public class UserServiceImpl implements UserService {

	@Override
	public Usuario getUsuario() {
		Usuario usuario = new Usuario();
		usuario.setUsuario("oshingc");
		usuario.setPassword("123456");
		return usuario;
	}

	@Override
	public Usuario login(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
