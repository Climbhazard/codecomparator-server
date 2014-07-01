package pe.edu.eapisw.codecomparator.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import pe.edu.eapisw.codecomparator.beans.model.Resultado;

public interface ResultadoMapper {

	@Options(useGeneratedKeys = true)
	@Insert("INSERT INTO `resultado`( `n_porcentaje_total`, `n_comparacion_id`, `t_primero`, `t_segundo`)"
			+ " VALUES (#{porcentajeTotal}, #{comparacion.comparacionId}, #{primero}, #{segundo})")
	public Integer saveResultado(Resultado resultado);
}
