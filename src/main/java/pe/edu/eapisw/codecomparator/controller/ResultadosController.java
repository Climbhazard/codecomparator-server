package pe.edu.eapisw.codecomparator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resultados")
public class ResultadosController {

	@RequestMapping("/layout")
	public String getLayout() {
		return "resultados/layout";
	}
}
