package pe.edu.eapisw.codecomparator.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import pe.edu.eapisw.codecomparator.beans.model.Comparacion;

public interface ComparacionMapper {

	@Insert("INSERT INTO `comparacion`(`n_tipo_comparacion`, `n_evaluacion_id`, `t_codigo_alumno_comparado`, `t_codigo_alumno_a_comparar`)"
			+ " VALUES (#{tipoComparacion}, #{evaluacion.n_evaluacion_id}, #{alumnoComparado.t_codigo}, #{alumnoAComparar.t_codigo})")
	public void saveComparacion(Comparacion comparacion);
	
	@Select(value="SELECT n_comparacion_id FROM `comparacion` ORDER BY n_comparacion_id DESC LIMIT 1")
	public Integer getLastId();
}
