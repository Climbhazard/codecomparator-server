package pe.edu.eapisw.codecomparator.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;

public interface UsuarioMapper {

	/*@Select("SELECT u.t_usuario as t_usuario, u.t_password as t_password, d.n_docente_id as n_docente_id, "
			+ "d.t_codigo as t_codigo , d.t_nombre as t_nombre, d.t_apellido_paterno as t_apellido_paterno, "
			+ "d.t_apellido_materno as t_apellido_materno "
			+ "FROM usuario u inner join docente d "
			+ "ON u.n_docente_id = d.n_docente_id "
			+ "WHERE t_usuario = #{usuario.usuario} and t_password = #{usuario.password}")
	@Results(value={
	            @Result(javaType =Usuario.class),
	            @Result(property ="usuario", column="t_usuario"),
	            @Result(property="password", column="t_password"),
	            @Result(property="docente.idDocente", column="n_docente_id"),
	            @Result(property="docente.codigo", column="t_codigo"),
	            @Result(property="docente.nombre", column="t_nombre"),
	            @Result(property="docente.apellidoPaterno", column="t_apellido_paterno"),
	            @Result(property="docente.apellidoMaterno", column="t_apellido_materno")	            
	})
	public Usuario loginDocente(@Param("usuario")Usuario usuario);*/
	
	/*@Select("SELECT n_usuario from usuario where t_usuario = #{usuario} and t_password = #{password}")
	@Results(value={
	            @Result(javaType =Usuario.class),
	            @Result(property ="id", column="n_usuario_id"),	            
	            @Result(property ="usuario", column="t_usuario"),
	            @Result(property="password", column="t_password")	                       
	})
	public Usuario loginUsuario(@Param("usuario")String usuario, @Param("password") String password);*/

	@Insert("INSERT INTO usuario (t_usuario, t_password) VALUES (#{usuario}, #{password})")
	public void crearUsuario(@Param("usuario") String usuario, @Param("password") String password);
	
	@Insert("INSERT INTO docente (t_codigo, t_nombre, t_apellido_paterno, t_apellido_materno) VALUES (#{codigo}, #{nombre}, #{apellidoPaterno}, #{apellidoMaterno})")
	public void crearDocente(@Param("codigo") String codigo, @Param("nombre") String nombre, @Param("apellidoPaterno") String apellidoPaterno, @Param("apellidoMaterno") String apellidoMaterno);


}