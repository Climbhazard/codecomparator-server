package pe.edu.eapisw.codecomparator.service;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import pe.edu.eapisw.codecomparator.beans.json.Codigo;
import pe.edu.eapisw.codecomparator.beans.json.Paquete;
import pe.edu.eapisw.codecomparator.beans.json.Proyecto;
import pe.edu.eapisw.codecomparator.beans.model.Usuario;
import pe.edu.eapisw.codecomparator.service.impl.JSONServiceImpl;
import pe.edu.eapisw.codecomparator.service.impl.UserServiceImpl;

public class UserServiceTest {

	//private UserService userService;

	@Before
	public void setUp() {
		//userService = new UserServiceImpl();
	}

	@Test
	public void testWhenUserLogged() {
		// JSONService jsonService = new JSONServiceImpl();
		Usuario usuarioExpected = new Usuario();
		usuarioExpected.setUsuario("oshingc");
		usuarioExpected.setPassword("123456");
		
		UserService userService = mock(UserService.class);		
		when(userService.login(usuarioExpected)).thenReturn(usuarioExpected);		
		Usuario usuarioActual = userService.login(usuarioExpected);
		assertEquals(usuarioExpected.getUsuario(),usuarioActual.getUsuario());
		assertEquals(usuarioExpected.getPassword(),usuarioActual.getPassword());
		
	}
	
	
}
