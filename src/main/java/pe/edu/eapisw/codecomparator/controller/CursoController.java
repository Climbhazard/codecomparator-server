package pe.edu.eapisw.codecomparator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.eapisw.codecomparator.beans.model.Curso;
import pe.edu.eapisw.codecomparator.service.CursoService;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	CursoService cursoService;

	@RequestMapping("/layout")
	public String getLayout() {
		return "curso/layout";
	}

	@RequestMapping(value = "/lista/{docenteId}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Curso> allCursos(
			@PathVariable(value = "docenteId") String docenteId) {
		return cursoService.allCursos(docenteId);
	}

	@RequestMapping(value = "/registrar", method = RequestMethod.POST)
	@ResponseBody
	public void registrarCurso(@RequestBody Curso curso) {
		cursoService.registrarCurso(curso);
	}

}
