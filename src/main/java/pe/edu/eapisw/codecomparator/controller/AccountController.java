package pe.edu.eapisw.codecomparator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;
import pe.edu.eapisw.codecomparator.service.CuentaService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private CuentaService cuentaService;

	@RequestMapping("/layout")
	public String getLayout() {
		return "account/layout";

	}

	@RequestMapping(value = "/registrardocente", method = RequestMethod.POST)
	@ResponseBody
	public void registrarDocente(@RequestBody Usuario usuario) {
		cuentaService.crearCuentaDocente(usuario);
	}

}
