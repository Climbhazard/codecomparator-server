package pe.edu.eapisw.codecomparator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.eapisw.codecomparator.beans.model.Docente;
import pe.edu.eapisw.codecomparator.beans.model.Usuario;
import pe.edu.eapisw.codecomparator.persistence.UsuarioMapper;
import pe.edu.eapisw.codecomparator.service.UsuarioService;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	public UsuarioMapper usuarioMapper;

	@Override
	public Usuario getUsuario() {
		Usuario usuario = new Usuario();
		//usuario.setUsuario("oshingc");
		//usuario.setPassword("123456");
		return usuario;
	}

	@Override
	public Usuario loginDocente(Usuario usuario) {		
		/*Usuario i = usuarioMapper.loginUsuario(usuario.getUsuario(), usuario.getPassword());
		System.out.println(i.getUsuario());
		System.out.println(i.getPassword());
		if(i==null){
			System.out.println("null");
		}else{
		System.out.println(i.getUsuario());
		System.out.println(i.getPassword());}
		return i;*/
		return null;

	}

	@Override
	@Transactional
	public void crearCuentaDocente(Usuario usuario) {
<<<<<<< HEAD
		usuarioMapper.crearDocente(usuario.getDocente().getCodigo(),usuario.getDocente().getNombre(), usuario.getDocente().getApellidoPaterno(), usuario.getDocente().getApellidoMaterno());
		usuarioMapper.crearUsuario(usuario.getUsuario(), usuario.getPassword());
=======
		// try{
		usuarioMapper.crearDocente(usuario.getDocente().getCodigo(), usuario
				.getDocente().getNombre(), usuario.getDocente()
				.getApellidoPaterno(), usuario.getDocente()
				.getApellidoMaterno());
		usuarioMapper.crearUsuario(usuario.getUsuario(), usuario.getPassword());
		// }catch(Exception e){
		// e.printStackTrace();
		// }
>>>>>>> 720f3b2ee7542a172e7d401cde630be0deaa09cc
	}

}
