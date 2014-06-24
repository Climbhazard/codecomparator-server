package pe.edu.eapisw.codecomparator.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.eapisw.codecomparator.beans.json.Evaluacion;
import pe.edu.eapisw.codecomparator.beans.json.Posicion;
import pe.edu.eapisw.codecomparator.beans.json.Proyecto;
import pe.edu.eapisw.codecomparator.beans.model.ContainerChartResult;
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

	@RequestMapping("/elegidos")
	public @ResponseBody void comparaProyectos(
			@RequestBody Collection<Posicion> elegidos) {
		Iterator<?> it = elegidos.iterator();
		while(it.hasNext()){
			System.out.println(it.getClass());			
			it.next();
		}/*
		ArrayList<Posicion> elegidosArray = (ArrayList<Posicion>)elegidos;
		for(int i=0; i<elegidos.size(); i++){
			Posicion po = (Posicion)elegidosArray.get(i);
			Proyecto p = po.getProyecto();
			System.out.println(p.getNombre());
			System.out.println(p.getCodigos());
			
		}*/
		System.out.println("ComparisonController.comparaProyectos()");
	}
	
	@RequestMapping("/comparar")
	public @ResponseBody void compararProyectos(
			@RequestBody ContenedorPosicion contenedor) {
		
		System.out.println(contenedor.getPosiciones().size());
		
		System.out.println("ComparisonController.comparaProyectos()");
		try{
		if(contenedor.getPosiciones().size()==2){

			ArrayList<Posicion> posiciones=  (ArrayList<Posicion>)contenedor.getPosiciones();
			Posicion posicion1 = posiciones.get(0);
			Proyecto proyecto1 = posicion1.getProyecto();
			Posicion posicion2 = posiciones.get(1);
			Proyecto proyecto2 = posicion2.getProyecto();
			
			ArrayList<ContainerChartResult> containerCharResult =(ArrayList<ContainerChartResult>) comparisonService.comparisionProject(proyecto1,proyecto2);
			System.out.println("size: "+containerCharResult.size());
			for(int i=0; i<containerCharResult.size(); i++){
				//System.out.println(containerCharResult.get(i).getNameFirstProyect());
				//System.out.println(containerCharResult.get(i).getNameSecondProyect());
				System.out.println(containerCharResult.get(i).getFdtw());
				//System.out.println(containerCharResult.get(i).getCodeFirstProyect().getContenido());
				//System.out.println(containerCharResult.get(i).getCodeSecondProyect().getContenido());
				//System.out.println(containerCharResult.get(i).getCodeFirstProyect().getQ());
				//System.out.println(containerCharResult.get(i).getCodeSecondProyect().getQ());
				
				
			}
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@RequestMapping("/layout")
	public String getLayout() {
		return "comparison/layout";
	}
}
