package pe.edu.eapisw.codecomparator.service.impl;

import org.springframework.stereotype.Service;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;
//import pe.edu.eapisw.codecomparator.persistence.UserMapper;
import pe.edu.eapisw.codecomparator.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

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