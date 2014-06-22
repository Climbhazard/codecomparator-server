package pe.edu.eapisw.codecomparator.service;

import static org.junit.Assert.*;

import org.junit.Test;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;
import pe.edu.eapisw.codecomparator.service.impl.JSONServiceImpl;

public class JSONServiceTest {

	@Test
	public void testToJson() {
		JSONService jsonService = new JSONServiceImpl();
		Usuario usuario = new Usuario();
		usuario.setUsuario("oshingc");
		usuario.setPassword("123456");
		String jsonExpected = "{\"usuario\":\"oshingc\",\"password\":\"123456\"}";
		String jsonActual = jsonService.toJson(usuario);
		assertEquals(jsonExpected, jsonActual);
	}

	@Test
	public void testToObject(){
		JSONService jsonService  = new JSONServiceImpl();
		Usuario usuarioExpected = new Usuario();
		usuarioExpected.setUsuario("oshingc");
		usuarioExpected.setPassword("123456");
		String json = "{\"usuario\":\"oshingc\",\"password\":\"123456\"}";
		Usuario usuarioActual = (Usuario)jsonService.toObject(json, Usuario.class);
		assertEquals(usuarioExpected, usuarioActual);

	}
}
