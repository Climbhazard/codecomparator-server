package pe.edu.eapisw.codecomparator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.eapisw.codecomparator.beans.model.Docente;
import pe.edu.eapisw.codecomparator.beans.model.Usuario;
import pe.edu.eapisw.codecomparator.persistence.DocenteMapper;
import pe.edu.eapisw.codecomparator.persistence.UsuarioMapper;
import pe.edu.eapisw.codecomparator.service.CuentaService;

@Service("cuentaService")
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private UsuarioMapper usuarioMapper;
	@Autowired
	private DocenteMapper docenteMapper;

	@Override
	public Usuario getUsuario() {
		Usuario usuario = new Usuario();
		// usuario.setUsuario("oshingc");
		// usuario.setPassword("123456");
		return usuario;
	}

	@Override
	public Docente loginDocente(Usuario usuario) {

		Docente docente = docenteMapper.loginDocente(usuario.getUsuario(),
				usuario.getPassword());
		return docente;

	}

	@Override
	@Transactional
	public void crearCuentaDocente(Usuario usuario) {

		docenteMapper.crearDocente(usuario.getDocente().getCodigo(), usuario
				.getDocente().getNombre(), usuario.getDocente()
				.getApellidoPaterno(), usuario.getDocente()
				.getApellidoMaterno());
		Integer docenteId = docenteMapper.getDocenteIdByCodigo(usuario
				.getDocente().getCodigo());
		usuarioMapper.crearUsuario(usuario.getUsuario(), usuario.getPassword(),
				docenteId);

	}

}
