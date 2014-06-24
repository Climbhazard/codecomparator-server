package pe.edu.eapisw.codecomparator.beans.model;

import java.util.List;

public class ContainerResult {

	private List<ContainerChartResult> charResults;

	public ContainerResult(){
		
	}
	
	public List<ContainerChartResult> getCharResults() {
		return charResults;
	}

	public void setCharResults(List<ContainerChartResult> charResults) {
		this.charResults = charResults;
	}
	
}
