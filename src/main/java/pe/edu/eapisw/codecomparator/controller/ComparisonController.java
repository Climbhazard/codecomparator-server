package pe.edu.eapisw.codecomparator.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.crsh.shell.impl.command.system.repl;
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
		docente.setDocenteId("/D010203");
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

		List<ContainerChartResult> resultado;

		for (Posicion posicion : posicionesRestantes) {
			resultado = comparisonService.comparisionProject(
					primeraPosicion.getProyecto(), posicion.getProyecto());
			containerResult.setCharResults(resultado);
		}

		return containerResult;
		// try {
		// if (contenedor.getPosiciones().size() == 2) {
		//
		// ArrayList<Posicion> posiciones = (ArrayList<Posicion>) contenedor
		// .getPosiciones();
		// Posicion posicion1 = posiciones.get(0);
		// Proyecto proyecto1 = posicion1.getProyecto();
		// Posicion posicion2 = posiciones.get(1);
		// Proyecto proyecto2 = posicion2.getProyecto();
		//
		// ArrayList<ContainerChartResult> containerCharResult =
		// (ArrayList<ContainerChartResult>) comparisonService
		// .comparisionProject(proyecto1, proyecto2);
		// System.out.println("size: " + containerCharResult.size());
		// for (int i = 0; i < containerCharResult.size(); i++) {
		// //
		// System.out.println(containerCharResult.get(i).getNameFirstProyect());
		// //
		// System.out.println(containerCharResult.get(i).getNameSecondProyect());
		// System.out.println(containerCharResult.get(i).getFdtw());
		// //
		// System.out.println(containerCharResult.get(i).getCodeFirstProyect().getContenido());
		// //
		// System.out.println(containerCharResult.get(i).getCodeSecondProyect().getContenido());
		// //
		// System.out.println(containerCharResult.get(i).getCodeFirstProyect().getQ());
		// //
		// System.out.println(containerCharResult.get(i).getCodeSecondProyect().getQ());
		//
		// }
		// containerResult.setCharResults(containerCharResult);
		// return containerResult;
		//
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return null;
	}

	@RequestMapping("/layout")
	public String getLayout() {
		return "comparison/layout";
	}
}
