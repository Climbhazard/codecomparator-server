package pe.edu.eapisw.codecomparator.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.eapisw.codecomparator.beans.model.Curso;
import pe.edu.eapisw.codecomparator.beans.model.Docente;
import pe.edu.eapisw.codecomparator.persistence.CursoMapper;
import pe.edu.eapisw.codecomparator.service.CursoService;

@Service("cursoService")
public class CursoServiceImpl implements CursoService {

	@Autowired
	CursoMapper cursoMapper;

	@Override
	public void registrarCurso(Curso curso) {
		Integer idDocente = Integer.parseInt(curso.getDocente().getDocenteId());
		cursoMapper.registrarCurso(curso.getNombre(),curso.getGrupo(),idDocente);		
	}

	@Override
	public List<Curso> allCursos(Docente docente) {
		
		Integer docenteId = 0;
		if(docente.getDocenteId()!=null){
			docenteId = Integer.parseInt(docente.getDocenteId());
		}		
		return cursoMapper.allCursos(docenteId);
	}
	
	
}
