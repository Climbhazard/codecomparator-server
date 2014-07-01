package pe.edu.eapisw.codecomparator.beans.model;

import pe.edu.eapisw.codecomparator.beans.json.Codigo;

public class ContainerChartResult {

	private String fdtw;
	private Codigo codeFirstProyect;
	private Codigo codeSecondProyect;
	private String nameFirstProyect;
	private String nameSecondProyect;

	public ContainerChartResult() {

	}

	public String getFdtw() {
		return fdtw;
	}

	public void setFdtw(String fdtw) {
		this.fdtw = fdtw;
	}

	public Codigo getCodeFirstProyect() {
		return codeFirstProyect;
	}

	public void setCodeFirstProyect(Codigo codeFirstProyect) {
		this.codeFirstProyect = codeFirstProyect;
	}

	public Codigo getCodeSecondProyect() {
		return codeSecondProyect;
	}

	public void setCodeSecondProyect(Codigo codeSecondProyect) {
		this.codeSecondProyect = codeSecondProyect;
	}

	public String getNameFirstProyect() {
		return nameFirstProyect;
	}

	public void setNameFirstProyect(String nameFirstProyect) {
		this.nameFirstProyect = nameFirstProyect;
	}

	public String getNameSecondProyect() {
		return nameSecondProyect;
	}

	public void setNameSecondProyect(String nameSecondProyect) {
		this.nameSecondProyect = nameSecondProyect;
	}

}
