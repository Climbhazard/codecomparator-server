package pe.edu.eapisw.codecomparator.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.eapisw.codecomparator.beans.json.Codigo;
import pe.edu.eapisw.codecomparator.beans.json.Evaluacion;
import pe.edu.eapisw.codecomparator.beans.json.Paquete;
import pe.edu.eapisw.codecomparator.beans.json.Posicion;
import pe.edu.eapisw.codecomparator.beans.json.Proyecto;
import pe.edu.eapisw.codecomparator.beans.model.Comparacion;
import pe.edu.eapisw.codecomparator.beans.model.ContainerChartResult;
import pe.edu.eapisw.codecomparator.beans.model.Curso;
import pe.edu.eapisw.codecomparator.beans.model.Docente;
import pe.edu.eapisw.codecomparator.beans.model.Resultado;
import pe.edu.eapisw.codecomparator.persistence.ComparacionMapper;
import pe.edu.eapisw.codecomparator.persistence.CursoMapper;
import pe.edu.eapisw.codecomparator.persistence.DropboxClient;
import pe.edu.eapisw.codecomparator.persistence.EvaluacionMapper;
import pe.edu.eapisw.codecomparator.persistence.ResultadoMapper;
import pe.edu.eapisw.codecomparator.service.ComparisonService;
import pe.edu.eapisw.codecomparator.service.core.fdtw.FDTW;
import pe.edu.eapisw.codecomparator.util.JSONUtil;

@Service("comparisonService")
public class ComparisonServiceImpl implements ComparisonService {

	private Collection<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();

	private JSONUtil jsonUtil = new JSONUtil();

	@Autowired
	private ComparacionMapper comparacionMapper;
	@Autowired
	private ResultadoMapper resultadoMapper;
	@Autowired
	private CursoMapper cursoMapper;
	@Autowired
	private EvaluacionMapper evaluacionMapper;
	@Autowired
	private DropboxClient dropboxUploader;

	private Codigo code2 = new Codigo();
	private Double min = new Double(0);

	/*@Override
	public Collection<Evaluacion> getEvaluaciones(Docente docente) {
		evaluaciones.clear();
		Curso algoritmica = new Curso();
		algoritmica.setCursoId(1);
		algoritmica.setGrupo(String.valueOf(2f));
		algoritmica.setNombre("Algorítmica II");

		Evaluacion eva1 = new Evaluacion();
		eva1.setN_evaluacion_id(1);
		;
		eva1.setCurso(algoritmica.getNombre());
		List<Evaluacion> evs = new ArrayList<Evaluacion>();
		evs.add(eva1);

		String codigoDocente = "/" + docente.getCodigo();
		String nombreCurso;
		String evaluacionId;
		String srcFilename;
		for (Evaluacion evaluacion : evs) {
			nombreCurso = "/" + evaluacion.getCurso();
			evaluacionId = "/"
					+ String.valueOf(evaluacion.getN_evaluacion_id());
			srcFilename = codigoDocente + nombreCurso + evaluacionId + ".json";

			this.evaluaciones
					.add((Evaluacion) jsonUtil.toObject(
							dropboxUploader
									.download(
											"Ns9nnNqlFpIAAAAAAAAABan7kFFoWTdnaddpwnxh_8DMeMHrBX1PORlMrPs2qGo6",
											srcFilename), Evaluacion.class));
		}

		return evaluaciones;
	}*/
	
	@Override
	public Collection<Evaluacion> getEvaluaciones(Docente docente) {
		evaluaciones.clear();
		/*Collection<Evaluacion> evaluacionesDocente = evaluacionMapper
				.getAllEvaluacionesByDocente(docente);*/
		
		Collection<Evaluacion> evaluacionesDocente = new ArrayList<Evaluacion>();

		Evaluacion eva = new Evaluacion();
		eva.setCurso("ED 1");
		eva.setN_evaluacion_id(1);
		evaluacionesDocente.add(eva);
		
		String codigoDocente = "/" + docente.getCodigo();
		String nombreCurso;
		String evaluacionId;
		String srcFilename;
		for (Evaluacion evaluacion : evaluacionesDocente) {
			nombreCurso = "/" + evaluacion.getCurso()/* .getNombre() */;
			evaluacionId = "/"
					+ String.valueOf(evaluacion.getN_evaluacion_id());
			srcFilename = codigoDocente + nombreCurso + evaluacionId + ".json";

			this.evaluaciones
			.add((Evaluacion) jsonUtil.toObject(getEvaluacionJson(), Evaluacion.class));
//			this.evaluaciones
//			.add((Evaluacion) jsonUtil.toObject(
//					dropboxUploader
//							.download(
//									"Ns9nnNqlFpIAAAAAAAAABan7kFFoWTdnaddpwnxh_8DMeMHrBX1PORlMrPs2qGo6",
//									srcFilename), Evaluacion.class));
		}

		return evaluaciones;
	}

	//

	/**
	 * Método inicial de comparación de proyectos
	 * 
	 * @author MaríaAlejandra (oshingc)
	 * @param Proyecto
	 *            project1
	 * @param Proyecto
	 *            project2
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
		ArrayList<Paquete> packages = (ArrayList<Paquete>) project1
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
			// container.setChartOne(this.generateGraphic(code));
			// container.setChartTwo(this.generateGraphic(this.code2));
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

			// container.setChartOne(this.generateGraphic(code));
			// container.setChartTwo(this.generateGraphic(this.code2));

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

	@Transactional
	@Override
	public Integer saveComparacion(Integer evaluacionId,
			Integer tipoComparacion, Posicion comparado, Posicion aComparar) {
		Comparacion comparacion = new Comparacion();
		comparacion.setTipoComparacion(tipoComparacion);
		comparacion.setEvaluacion(new Evaluacion());
		comparacion.getEvaluacion().setN_evaluacion_id(evaluacionId);
		comparacion.setAlumnoComparado(comparado.getAlumno());
		comparacion.setAlumnoAComparar(aComparar.getAlumno());

		comparacionMapper.saveComparacion(comparacion);
		return comparacionMapper.getLastId();
	}

	@Override
	public void saveResultado(Integer comparacionId,
			List<ContainerChartResult> resultados) {
		Resultado resultado = null;
		for (ContainerChartResult container : resultados) {
			resultado = new Resultado();
			resultado.setComparacion(new Comparacion());
			resultado.getComparacion().setComparacionId(comparacionId);
			resultado
					.setPorcentajeTotal(Double.parseDouble(container.getFdtw()));
			resultado.setPrimero(jsonUtil.toJson(container
					.getCodeFirstProyect()));
			resultado.setSegundo(jsonUtil.toJson(container
					.getCodeSecondProyect()));
			resultadoMapper.saveResultado(resultado);
		}
	}
	
	@SuppressWarnings("unused")
	private String getEvaluacionJson(){
		String content = "";
		String line = "";
		String p = "C:\\Users\\MaríaAlejandra\\Documents\\codecomparator-server\\src\\main\\java\\pe\\edu\\eapisw\\codecomparator\\controller\\1.json";
		try {
			BufferedReader br = new BufferedReader(new FileReader(p));
			try {
				while ((line = br.readLine()) != null) {
					content += line + "\n";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}
}
