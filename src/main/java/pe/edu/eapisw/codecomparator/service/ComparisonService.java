package pe.edu.eapisw.codecomparator.service;

import java.util.Collection;

import pe.edu.eapisw.codecomparator.beans.json.Evaluacion;
import pe.edu.eapisw.codecomparator.beans.model.Docente;

public interface ComparisonService {
	/**
	 * Carga las evaluaciones pertenecientes al <code>docente</code>.
	 * 
	 * @param docente
	 * @return <code>Evaluaciones</code>
	 */
	public Collection<Evaluacion> getEvaluaciones(Docente docente);
}
