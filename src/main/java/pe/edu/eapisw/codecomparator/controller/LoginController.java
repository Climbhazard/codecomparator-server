package pe.edu.eapisw.codecomparator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.eapisw.codecomparator.beans.Usuario;
import pe.edu.eapisw.codecomparator.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService usuarioService;

	@RequestMapping(value = "/user.json")
	public @ResponseBody Usuario getUsuario() {
		System.out.println("LoginController.getUsuario()");
		return usuarioService.getUsuario();
	}
}
