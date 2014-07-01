package pe.edu.eapisw.codecomparator.persistence;

import java.util.Collection;

import org.apache.ibatis.annotations.Select;

import pe.edu.eapisw.codecomparator.beans.json.Evaluacion;
import pe.edu.eapisw.codecomparator.beans.model.Curso;
import pe.edu.eapisw.codecomparator.beans.model.Docente;

public interface EvaluacionMapper {

	public Collection<Evaluacion> getAllEvaluacionesByCurso(Curso curso);

	@Select("SELECT `n_evaluacion_id` AS n_evaluacion_id, `titulo`, `tiempo`, `curso`, `grupo`, `descripcion`, `d_fecha_registro` AS fechaRegistro "
			+ "FROM `evaluacion` WHERE evaluacion.n_docente_id = #{docenteId}")
	public Collection<Evaluacion> getAllEvaluacionesByDocente(Docente docente);
}