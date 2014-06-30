package pe.edu.eapisw.codecomparator.persistence;

import java.util.Collection;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import pe.edu.eapisw.codecomparator.beans.model.Curso;
import pe.edu.eapisw.codecomparator.beans.model.Docente;

public interface CursoMapper {

	public Collection<Curso> getAllCursosByDocente(Docente docente);
	
	@Insert("INSERT INTO curso(t_nombre,n_grupo,n_docente_id) "
			+ "VALUES (#{nombre}, #{grupo},#{docenteid})")

	public void registrarCurso(@Param("nombre") String nombre,
			@Param("grupo") String grupo,
			@Param("ndocenteid") Integer ndocenteid);
}
