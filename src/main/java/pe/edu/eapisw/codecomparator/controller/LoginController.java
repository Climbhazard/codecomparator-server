package pe.edu.eapisw.codecomparator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.eapisw.codecomparator.beans.model.Docente;
import pe.edu.eapisw.codecomparator.beans.model.Usuario;
import pe.edu.eapisw.codecomparator.service.CuentaService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private CuentaService cuentaService;

	@RequestMapping(value = "/user.json")
	public @ResponseBody Usuario getUsuario() {
		System.out.println("LoginController.getUsuario()");
		return cuentaService.getUsuario();
	}

	@RequestMapping(value = "/docente", method = RequestMethod.POST)
	public @ResponseBody Docente getLoginDocente(@RequestBody Usuario usuario) {
		return cuentaService.loginDocente(usuario);
	}

	@RequestMapping("/layout")
	public String getLayout() {
		return "login/layout";
	}

}
