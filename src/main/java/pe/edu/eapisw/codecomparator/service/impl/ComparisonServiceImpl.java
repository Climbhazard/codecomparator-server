package pe.edu.eapisw.codecomparator.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.edu.eapisw.codecomparator.beans.json.Evaluacion;
import pe.edu.eapisw.codecomparator.beans.model.Curso;
import pe.edu.eapisw.codecomparator.beans.model.Docente;
import pe.edu.eapisw.codecomparator.persistence.DropboxClient;
import pe.edu.eapisw.codecomparator.persistence.impl.DropboxClientImpl;
import pe.edu.eapisw.codecomparator.service.ComparisonService;
import pe.edu.eapisw.codecomparator.util.JSONUtil;

@Service("comparisonService")
public class ComparisonServiceImpl implements ComparisonService {

	private Collection<Evaluacion> evaluaciones = new ArrayList<Evaluacion>();

	private JSONUtil jsonUtil = new JSONUtil();
	// TODO: reorganizar estos objetos para manipularlos con Spring
	private DropboxClient dropboxUploader = new DropboxClientImpl();

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
			srcFilename = docenteId + nombreCurso + evaluacionId;

			this.evaluaciones.add((Evaluacion) jsonUtil.toObject(
					dropboxUploader.download("Ns9nnNqlFpIAAAAAAAAABan7kFFoWTdnaddpwnxh_8DMeMHrBX1PORlMrPs2qGo6",
							srcFilename), Evaluacion.class));
		}

		return evaluaciones;
	}
}
