package pe.edu.eapisw.codecomparator.service;

import java.util.List;

import pe.edu.eapisw.codecomparator.beans.model.Curso;
import pe.edu.eapisw.codecomparator.beans.model.Docente;

public interface CursoService {
	
	public List<Curso> allCursos(String docenteId);
	
	public void registrarCurso(Curso curso);

}
