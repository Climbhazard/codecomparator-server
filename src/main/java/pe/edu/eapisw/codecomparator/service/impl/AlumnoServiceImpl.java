package pe.edu.eapisw.codecomparator.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.eapisw.codecomparator.beans.model.Alumno;
import pe.edu.eapisw.codecomparator.beans.model.Curso;
import pe.edu.eapisw.codecomparator.persistence.AlumnoMapper;
import pe.edu.eapisw.codecomparator.persistence.CursoMapper;
import pe.edu.eapisw.codecomparator.service.AlumnoService;
import pe.edu.eapisw.codecomparator.service.CursoService;

@Service("alumnoService")
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoMapper alumnoMapper;

	@Override
	public void registrarAlumno(Alumno alumno) {
		Integer idDocente = Integer.parseInt(alumno.getDocente().getDocenteId());
		alumnoMapper.registrarAlumno(alumno.getT_codigo(), alumno.getT_nombre(), alumno.getT_apellido_paterno(),
				alumno.getT_apellido_materno(), idDocente);	
		
	}

	@Override
	public void updateAlumno(String curso, String grupo, String alumnoId) {
		Integer alumnoIdInt = 0;
		if(alumnoId!=null){
			alumnoIdInt = Integer.parseInt(alumnoId);
		}
		System.out.println("AlumnoServiceImpl.updateAlumno()");
		System.out.println(alumnoIdInt);
		alumnoMapper.updateAlumno(curso, grupo, alumnoIdInt);
		
	}
	
	
}
