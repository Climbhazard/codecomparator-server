package pe.edu.eapisw.codecomparator.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.eapisw.codecomparator.beans.model.Comparacion;
import pe.edu.eapisw.codecomparator.beans.model.Docente;
import pe.edu.eapisw.codecomparator.service.ComparisonService;

@Controller
@RequestMapping("/historial")
public class HistorialController {

	@Autowired
	private ComparisonService comparisonService;

	@RequestMapping("/comparaciones.json")
	public @ResponseBody Collection<Comparacion> getComparaciones() {
		Docente docente = new Docente();
		docente.setDocenteId(String.valueOf(1));
		docente.setCodigo("D010203");
		return comparisonService.getComparaciones(docente);
	}

	@RequestMapping("/layout")
	public String getLayout() {
		return "historial/layout";

	}
}
