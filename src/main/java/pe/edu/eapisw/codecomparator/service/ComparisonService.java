package pe.edu.eapisw.codecomparator.service;

import java.util.Collection;
import java.util.List;

import pe.edu.eapisw.codecomparator.beans.json.Evaluacion;
import pe.edu.eapisw.codecomparator.beans.json.Proyecto;
import pe.edu.eapisw.codecomparator.beans.model.ContainerChartResult;
import pe.edu.eapisw.codecomparator.beans.model.Docente;

public interface ComparisonService {
	/**
	 * Carga las evaluaciones pertenecientes al <code>docente</code>.
	 * 
	 * @param docente
	 * @return <code>Evaluaciones</code>
	 */
	public Collection<Evaluacion> getEvaluaciones(Docente docente);
	
	public List<ContainerChartResult> comparisionProject(Proyecto project1,
			Proyecto project2);
}
