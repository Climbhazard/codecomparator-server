package pe.edu.eapisw.codecomparator.persistence;

import java.util.Collection;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import pe.edu.eapisw.codecomparator.beans.model.Curso;

public interface CursoMapper {

	@Select("SELECT curso.n_curso_id AS cursoId, curso.t_nombre AS nombre, curso.n_grupo AS grupo "
			+ "FROM `curso`, docente WHERE docente.t_codigo = #{codigo} AND docente.n_docente_id = curso.n_docente_id ")
	public Collection<Curso> getAllCursosByDocente(
			@Param("codigo") String codigo);

}
