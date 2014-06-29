package pe.edu.eapisw.codecomparator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;
import pe.edu.eapisw.codecomparator.service.UsuarioService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/user.json")
	public @ResponseBody Usuario getUsuario() {
		System.out.println("LoginController.getUsuario()");
		return usuarioService.getUsuario();
	}

	@RequestMapping(value = "/docente", method = RequestMethod.POST)
	public @ResponseBody Usuario getLoginDocente(@RequestBody Usuario usuario) {
		System.out.println("LoginController.getUsuario()");
		Usuario u =usuarioService.loginDocente(usuario); 
		return u;
	}

	@RequestMapping("/layout")
	public String getLayout() {
		return "login/layout";
	}
}
