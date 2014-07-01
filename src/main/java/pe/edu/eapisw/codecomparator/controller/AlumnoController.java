package pe.edu.eapisw.codecomparator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.eapisw.codecomparator.beans.model.Alumno;
import pe.edu.eapisw.codecomparator.service.AlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {

	@Autowired
	AlumnoService alumnoService;

	@RequestMapping("/layout")
	public String getLayout() {
		return "alumno/layout";

	}

	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	@ResponseBody
	public void registrarCurso(@RequestBody Alumno alumno) {
		alumnoService.registrarAlumno(alumno);
	}

}
