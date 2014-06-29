package pe.edu.eapisw.codecomparator.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;

public interface UsuarioMapper {

	@Select("SELECT * FROM usuario WHERE t_usuario = #{usuario} and t_password = #{password}")
	public Usuario loginDocente(Usuario usuario);

	@Insert("INSERT INTO usuario (t_usuario, t_password) VALUES (#{usuario}, #{password})")
	public void crearUsuario(@Param("usuario") String usuario, @Param("password") String password);
	
	@Insert("INSERT INTO docente (t_codigo, t_nombre, t_apellido_paterno, t_apellido_materno) VALUES (#{codigo}, #{nombre}, #{apellidoPaterno}, #{apellidoMaterno})")
	public void crearDocente(@Param("codigo") String codigo, @Param("nombre") String nombre, @Param("apellidoPaterno") String apellidoPaterno, @Param("apellidoMaterno") String apellidoMaterno);


}