package pe.edu.eapisw.codecomparator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inicio")
public class InicioController {

    @RequestMapping("/layout")
    public String getLayout() {
        return "inicio/layout";
       
    }
}
