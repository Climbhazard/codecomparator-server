package pe.edu.eapisw.codecomparator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.eapisw.codecomparator.beans.model.Curso;
import pe.edu.eapisw.codecomparator.persistence.CursoMapper;
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
    
    @RequestMapping("/registrar/{nombre}/{grupo}/{docenteid}")    
    public void registrarCurso(@PathVariable(value="nombre") String nombre, @PathVariable(value="grupo") String grupo, @PathVariable(value="docenteId") Integer docenteId){
    	cursoService.registrarCurso(nombre,grupo,docenteId);
    }
}
