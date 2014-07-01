package pe.edu.eapisw.codecomparator.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.eapisw.codecomparator.beans.json.Evaluacion;
import pe.edu.eapisw.codecomparator.beans.json.Posicion;
import pe.edu.eapisw.codecomparator.beans.model.ContainerChartResult;
import pe.edu.eapisw.codecomparator.beans.model.ContainerResult;
import pe.edu.eapisw.codecomparator.beans.model.ContenedorPosicion;
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
		docente.setCodigo("/D010203");
		return comparisonService.getEvaluaciones(docente);
	}

	@RequestMapping("/comparar")
	public @ResponseBody ContainerResult compararProyectos(
			@RequestBody ContenedorPosicion contenedor) {

		ContainerResult containerResult = new ContainerResult();

		// posición contra las que demás se compararán
		Posicion primeraPosicion = ((ArrayList<Posicion>) contenedor
				.getPosiciones()).get(0);

		// retiramos la primera posición de la colección de posiciones
		contenedor.getPosiciones().remove(primeraPosicion);

		// posiciones restantes
		Collection<Posicion> posicionesRestantes = contenedor.getPosiciones();

		List<ContainerChartResult> resultados;

		for (Posicion posicion : posicionesRestantes) {
			resultados = comparisonService.comparisionProject(
					primeraPosicion.getProyecto(), posicion.getProyecto());
			containerResult.setCharResults(resultados);

			Integer comparacionId = comparisonService.saveComparacion(
					contenedor.getEvaluacionId(),
					contenedor.getTipoComparacion(), primeraPosicion, posicion);

			comparisonService.saveResultado(comparacionId, resultados);
		}

		return containerResult;
	}

	@RequestMapping("/layout")
	public String getLayout() {
		return "comparison/layout";
	}
}
