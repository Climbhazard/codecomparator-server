package pe.edu.eapisw.codecomparator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cambiarPass")
public class CambiarPassController {

    @RequestMapping("/layout")
    public String getLayout() {
        return "cambiarPass/layout";
       
    }
}
