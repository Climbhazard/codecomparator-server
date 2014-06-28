package pe.edu.eapisw.codecomparator.beans.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ContainerResult {

	private Collection<List<ContainerChartResult>> charResults;

	public ContainerResult() {
		charResults = new ArrayList<List<ContainerChartResult>>();
	}

	public Collection<List<ContainerChartResult>> getCharResults() {
		return charResults;
	}

	/**
	 * @param charResults
	 *            resultado de una comparación de dos proyectos.
	 */
	public void setCharResults(List<ContainerChartResult> charResults) {
		this.charResults.add(charResults);
	}

}
