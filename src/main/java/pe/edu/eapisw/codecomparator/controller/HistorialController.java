package pe.edu.eapisw.codecomparator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/historial")
public class HistorialController {

    @RequestMapping("/layout")
    public String getLayout() {
        return "historial/layout";
       
    }
}
