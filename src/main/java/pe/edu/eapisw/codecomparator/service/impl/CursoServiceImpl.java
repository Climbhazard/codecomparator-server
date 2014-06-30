package pe.edu.eapisw.codecomparator.service.impl;

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
	public void registrarCurso(String nombre, String grupo, Integer docenteId) {
		cursoMapper.registrarCurso(nombre,grupo,docenteId);
		
	}
	
	
}
