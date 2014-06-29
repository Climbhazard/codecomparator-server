package pe.edu.eapisw.codecomparator.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;

public interface UsuarioMapper {

	@Select("SELECT * FROM usuario WHERE t_usuario = #{usuario} and t_password = #{password}")
	public Usuario loginDocente(Usuario usuario);

	@Insert("INSERT INTO usuario (t_usuario, t_password) VALUES (#{usuario}, #{password})")
	public int crearCuentaDocente(Usuario usuario);

}
