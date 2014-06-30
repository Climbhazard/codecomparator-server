package pe.edu.eapisw.codecomparator.service;

import pe.edu.eapisw.codecomparator.beans.model.Curso;

public interface CursoService {
	
	public void registrarCurso(String nombre, String grupo, Integer docenteId);

}
