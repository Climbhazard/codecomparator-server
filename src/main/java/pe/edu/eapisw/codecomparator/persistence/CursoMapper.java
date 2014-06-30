package pe.edu.eapisw.codecomparator.persistence;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import pe.edu.eapisw.codecomparator.beans.model.Curso;
import pe.edu.eapisw.codecomparator.beans.model.Docente;

public interface CursoMapper {

	public Collection<Curso> getAllCursosByDocente(Docente docente);
	
	@Insert("INSERT INTO curso(t_nombre,n_grupo,n_docente_id) "
			+ "VALUES (#{nombre}, #{grupo},#{ndocenteid})")

	public void registrarCurso(@Param("nombre") String nombre,
			@Param("grupo") String grupo,
			@Param("ndocenteid") Integer ndocenteid);
	
	 @Select(value = "SELECT n_curso_id, t_nombre, n_grupo, n_docente_id, "
	 		+ "FROM curso where n_docente_id = #{ndocenteid}")
	 @Results(value = {
	            @Result(column = "n_curso_id", property = "cursoId"),
	            @Result(column = "t_nombre", property = "nombre"),
	            @Result(column = "t_grupo", property = "grupo"),
	            @Result(column = "n_docente_id", property = "docente.docenteId")
	 })
	 List<Curso> allCursos(@Param("ndocenteid") Integer ndocenteid);
}
