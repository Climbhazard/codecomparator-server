package pe.edu.eapisw.codecomparator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comparacion")
public class ComparacionController {

    @RequestMapping("/layout")
    public String getLayout() {
        return "comparison/layout";
       
    }
}
