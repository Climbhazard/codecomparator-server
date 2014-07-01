package pe.edu.eapisw.codecomparator.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import pe.edu.eapisw.codecomparator.beans.model.Resultado;

public interface ResultadoMapper {

	@Insert("INSERT INTO `resultado`( `n_porcentaje_total`, `n_comparacion_id`, `t_primero`, `t_segundo`)"
			+ " VALUES (#{porcentajeTotal}, #{comparacion.comparacionId}, #{primero}, #{segundo})")
	public void saveResultado(Resultado resultado);

	@Select(value = "SELECT n_resultado_id FROM `resultado` ORDER BY n_resultado_id DESC LIMIT 1")
	public Integer getLastId();
}
