package pe.edu.eapisw.codecomparator.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface ComparacionMapper {

	@Insert("INSERT INTO `comparacion`(`n_tipo_comparacion`, `n_evaluacion_id`, `t_codigo_alumno_comparado`, `t_codigo_alumno_a_comparar`)"
			+ " VALUES (#{tipoComparacion}, #{evaluacionId}, #{codigoComparado}, #{codigoAComparar})")
	public void saveComparacion(@Param("evaluacionId") Integer evaluacionId,
			@Param("tipoComparacion") Integer tipoComparacion,
			@Param("codigoComparado") String codigoComparado,
			@Param("codigoAComparar") String codigoAComparar);
}
