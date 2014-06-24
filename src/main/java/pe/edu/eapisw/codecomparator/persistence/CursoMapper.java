package pe.edu.eapisw.codecomparator.persistence;

import java.util.Collection;

import pe.edu.eapisw.codecomparator.beans.model.Curso;
import pe.edu.eapisw.codecomparator.beans.model.Docente;

public interface CursoMapper {

	public Collection<Curso> getAllCursosByDocente(Docente docente);
}
