package pe.edu.eapisw.codecomparator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;
import pe.edu.eapisw.codecomparator.persistence.UserMapper;
import pe.edu.eapisw.codecomparator.service.UserService;

@Service("usuarioService")
public class UserServiceImpl implements UserService {

	/*@Autowired
	public UserMapper userMapper;*/
	
	@Override
	public Usuario getUsuario() {
		Usuario usuario = new Usuario();
		usuario.setUsuario("oshingc");
		usuario.setPassword("123456");
		return usuario;
	}

	@Override
	public Usuario loginDocente(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void crearCuentaDocente(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public Usuario loginDocente(Usuario usuario) {
		return userMapper.loginDocente(usuario);		
	}

	@Override
	public void crearCuentaDocente(Usuario usuario) {
		userMapper.crearCuentaDocente(usuario);		
	}*/

}
