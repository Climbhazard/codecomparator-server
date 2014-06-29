package pe.edu.eapisw.codecomparator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @RequestMapping("/layout")
    public String getLayout() {
        return "curso/layout";
       
    }
}
