package pe.edu.eapisw.codecomparator.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UsuarioMapper {

	@Insert("INSERT INTO usuario (t_usuario, t_password, n_docente_id) VALUES (#{usuario}, #{password}, #{docenteId})")
	public void crearUsuario(@Param("usuario") String usuario,
			@Param("password") String password,
			@Param("docenteId") Integer docenteId);

}