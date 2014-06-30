package pe.edu.eapisw.codecomparator.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import pe.edu.eapisw.codecomparator.beans.model.Docente;

public interface DocenteMapper {

	@Insert("INSERT INTO docente (t_codigo, t_nombre, t_apellido_paterno, t_apellido_materno) VALUES (#{codigo}, #{nombre}, #{apellidoPaterno}, #{apellidoMaterno})")
	public void crearDocente(@Param("codigo") String codigo,
			@Param("nombre") String nombre,
			@Param("apellidoPaterno") String apellidoPaterno,
			@Param("apellidoMaterno") String apellidoMaterno);

	// retornar los campos cuyos nombres y tipos sean compatibles a los nombres
	// y campos de la clase que se quiere poblar
	// @Select("SELECT usuario.n_usuario_id AS id, usuario.t_usuario AS usuario, usuario.t_password AS password FROM usuario WHERE t_usuario = #{usuario} AND t_password = #{password}")
	@Select("SELECT docente.n_docente_id AS docenteId, docente.t_nombre AS nombre, docente.t_codigo AS codigo, docente.t_apellido_paterno AS apellidoPaterno, docente.t_apellido_materno AS apellidoMaterno"
			+ " FROM `docente`, usuario WHERE usuario.t_usuario = #{usuario} and usuario.t_password = #{password} and usuario.n_docente_id = docente.n_docente_id ")
	public Docente loginDocente(@Param("usuario") String usuario,
			@Param("password") String password);

	@Select("SELECT docente.n_docente_id FROM docente WHERE t_codigo = #{codigo}")
	public Integer getDocenteIdByCodigo(@Param("codigo") String codigo);

}
