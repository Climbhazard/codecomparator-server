package pe.edu.eapisw.codecomparator.core.converter;

import java.util.ArrayList;

public class CodeImage {

	private ArrayList<Double> codeImg;
	private String codeLine;

	public CodeImage() {
		super();
	}

	public CodeImage(ArrayList<Double> codeImg, String codeLine) {
		super();
		this.codeImg = codeImg;
		this.codeLine = codeLine;
	}

	public ArrayList<Double> getCode_img() {
		return codeImg;
	}

	public void setCodeImg(ArrayList<Double> codeImg) {
		this.codeImg = codeImg;
	}

	public String getCodeLine() {
		return codeLine;
	}

	public void setCodeLine(String codeLine) {
		this.codeLine = codeLine;
	}

}
