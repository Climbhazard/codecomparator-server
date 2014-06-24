package pe.edu.eapisw.codecomparator.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.eapisw.codecomparator.beans.json.Evaluacion;
import pe.edu.eapisw.codecomparator.beans.json.Posicion;
import pe.edu.eapisw.codecomparator.beans.model.Docente;
import pe.edu.eapisw.codecomparator.service.ComparisonService;

@Controller
@RequestMapping("/comparison")
public class ComparisonController {

	@Autowired
	private ComparisonService comparisonService;

	@RequestMapping("/evaluaciones.json")
	public @ResponseBody Collection<Evaluacion> getEvaluaciones() {
		Docente docente = new Docente();
		docente.setDocenteId("/D010203");
		return comparisonService.getEvaluaciones(docente);
	}

	@RequestMapping("/elegidos")
	public @ResponseBody void comparaProyectos(
			@RequestBody Collection<Posicion> elegidos) {
		Iterator<?> it = elegidos.iterator();
		while(it.hasNext()){
			System.out.println(it.getClass());
			it.next();
		}
		System.out.println("ComparisonController.comparaProyectos()");
	}

	@RequestMapping("/layout")
	public String getLayout() {
		return "comparison/layout";
	}
}
