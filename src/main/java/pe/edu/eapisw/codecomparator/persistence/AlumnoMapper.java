package pe.edu.eapisw.codecomparator.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Param;

public interface AlumnoMapper {
	@Insert("INSERT INTO alumno(t_codigo,t_nombre,t_apellido_paterno,"
			+ "t_apellido_materno,n_docente_id) "
			+ "VALUES ( #{codigo}, #{nombre},#{apellidoPaterno}, #{apellidoMaterno},"
			+ "#{ndocenteid}")
	public void registrarAlumno(@Param("codigo") String codigo,
			@Param("nombre") String nombre,
			@Param("apellidoPaterno") String apellidoPaterno,
			@Param("apellidoMaterno") String apellidoMaterno,
			@Param("ndocenteid") Integer ndocenteid);
	//@Param("grupo") String grupo, se le agreg grupo luego, luego se hara update
	
	@Update("UPDATE alumno set t_curso = #{curso}, t_grupo = #{grupo} where n_alumno_id = #{alumnoid}")
	public void updateAlumno(@Param("curso") String curso,
			@Param("grupo") String grupo,
			@Param("alumnoid") Integer alumnoid);
	
	
}
