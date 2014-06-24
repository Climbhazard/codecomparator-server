package pe.edu.eapisw.codecomparator.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.eapisw.codecomparator.beans.json.Codigo;
import pe.edu.eapisw.codecomparator.beans.json.Evaluacion;
import pe.edu.eapisw.codecomparator.beans.json.Paquete;
import pe.edu.eapisw.codecomparator.beans.json.Proyecto;
import pe.edu.eapisw.codecomparator.beans.model.ContainerChartResult;
import pe.edu.eapisw.codecomparator.beans.model.Curso;
import pe.edu.eapisw.codecomparator.beans.model.Docente;
import pe.edu.eapisw.codecomparator.persistence.DropboxClient;
import pe.edu.eapisw.codecomparator.persistence.impl.DropboxClientImpl;
import pe.edu.eapisw.codecomparator.service.ComparisonService;
import pe.edu.eapisw.codecomparator.service.core.fdtw.FDTW;
import pe.edu.eapisw.codecomparator.util.JSONUtil;

@Service("comparisonService")
public class ComparisonServiceImpl implements ComparisonService {

	private Collection<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();

	private JSONUtil jsonUtil = new JSONUtil();
	// TODO: reorganizar estos objetos para manipularlos con Spring
	private DropboxClient dropboxUploader = new DropboxClientImpl();
	
	private Codigo code2 = new Codigo();
	private Double min = new Double(0); 

	@Override
	public Collection<Evaluacion> getEvaluaciones(Docente docente) {
		evaluaciones.clear();
		// simulo traer un todos los cursos del docente
		Curso algoritmica = new Curso();
		algoritmica.setCursoId(1);
		algoritmica.setGrupo(2);
		algoritmica.setNombre("Algorítmica II");

		// traigo todas las evaluaciones de este curso
		Evaluacion eva1 = new Evaluacion();
		eva1.setEvaluacionId(1);
		eva1.setCurso(algoritmica);
		List<Evaluacion> evs = new ArrayList<Evaluacion>();
		evs.add(eva1);

		String docenteId = "/" + docente.getDocenteId();
		String nombreCurso;
		String evaluacionId;
		String srcFilename;
		for (Evaluacion evaluacion : evs) {
			nombreCurso = "/" + evaluacion.getCurso().getNombre();
			evaluacionId = "/" + String.valueOf(evaluacion.getEvaluacionId());
			srcFilename = docenteId + nombreCurso + evaluacionId + ".json";

			this.evaluaciones
					.add((Evaluacion) jsonUtil.toObject(
							dropboxUploader
									.download(
											"Ns9nnNqlFpIAAAAAAAAABan7kFFoWTdnaddpwnxh_8DMeMHrBX1PORlMrPs2qGo6",
											srcFilename), Evaluacion.class));
		}

		return evaluaciones;
	}
	

	//
	
	/**
	 * Método inicial de comparación de proyectos
	 * @author MaríaAlejandra (oshingc)
	 * @param Proyecto project1
	 * @param Proyecto project2
	 * 
	 * */
	
	@Override
	public List<ContainerChartResult> comparisionProject(Proyecto project1,
			Proyecto project2) {
		List<ContainerChartResult> containers = new ArrayList<ContainerChartResult>();

		travelComparisionProject(project1, project2, containers);
		return containers;
	}
	
	private Double compareFiles(Codigo code1, Codigo code2) {
        FDTW fdtw = new FDTW();
        fdtw.SetSequences(code1.getQ(), code2.getQ());
        Double a = fdtw.GetDistance();
        return a;
	}
	
	private void travelComparisionProject(Proyecto project1, Proyecto project2,
			List<ContainerChartResult> containers) {
		ArrayList<Codigo> codes = (ArrayList<Codigo>) project1.getCodigos();
		ArrayList<Paquete> packages = (ArrayList<Paquete>) project1.getPaquetes();

		for (Codigo code : codes) {
			this.code2 = new Codigo();
			this.min = new Double(Double.MAX_VALUE);
			travelComparisionMinProject(project2, code);

			ContainerChartResult container = new ContainerChartResult();

			container.setCodeFirstProyect(code);
			container.setCodeSecondProyect(this.code2);
			container.setFdtw(String.valueOf(this.min));
			container.setNameFirstProyect(project1.getNombre());
			container.setNameSecondProyect(project2.getNombre());
			//container.setChartOne(this.generateGraphic(code));
			//container.setChartTwo(this.generateGraphic(this.code2));
			containers.add(container);
		}

		for (Paquete _package : packages) {
			travelComparisionProject(_package, project1, project2, containers);
		}

	}
	
	
	private void travelComparisionProject(Paquete package1, Proyecto project1,
			Proyecto project2, List<ContainerChartResult> containers) {
		ArrayList<Codigo> codes = (ArrayList<Codigo>) package1.getCodigos();
		ArrayList<Paquete> packages = (ArrayList<Paquete>) package1
				.getPaquetes();

		for (Codigo code : codes) {
			this.code2 = new Codigo();
			this.min = new Double(Double.MAX_VALUE);
			travelComparisionMinProject(project2, code);
			ContainerChartResult container = new ContainerChartResult();
			container.setCodeFirstProyect(code);
			container.setCodeSecondProyect(this.code2);
			container.setFdtw(String.valueOf(this.min));
			container.setNameFirstProyect(project1.getNombre());
			container.setNameSecondProyect(project2.getNombre());

			//container.setChartOne(this.generateGraphic(code));
			//container.setChartTwo(this.generateGraphic(this.code2));

			containers.add(container);

		}

		for (Paquete _package : packages) {
			travelComparisionProject(_package, project1, project2, containers);
		}

	}
	
	
	private void travelComparisionMinProject(Proyecto project2, Codigo code1) {

		ArrayList<Codigo> codes = (ArrayList<Codigo>) project2.getCodigos();
		ArrayList<Paquete> packages = (ArrayList<Paquete>) project2
				.getPaquetes();

		for (Codigo code : codes) {
			Double rpt = compareFiles(code1, code);
			if (rpt < this.min) {
				this.code2 = code;
				this.min = new Double(rpt);
			}
		}

		for (Paquete _package : packages) {
			travelComparisionMinProject(_package, code1);
		}

	}

	private void travelComparisionMinProject(Paquete package2, Codigo code1) {

		ArrayList<Codigo> codes = (ArrayList<Codigo>) package2.getCodigos();
		ArrayList<Paquete> packages = (ArrayList<Paquete>) package2
				.getPaquetes();

		for (Codigo code : codes) {
			Double rpt = compareFiles(code1, code);
			if (rpt < this.min) {
				this.code2 = code;
				this.min = new Double(rpt);
			}
		}

		for (Paquete _package : packages) {
			travelComparisionMinProject(_package, code1);
		}

	}
	
}
