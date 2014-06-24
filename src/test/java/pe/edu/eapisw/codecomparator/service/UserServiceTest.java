package pe.edu.eapisw.codecomparator.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;

public class UserServiceTest {

	@Before
	public void setUp() {
		// userService = new UserServiceImpl();
	}

	@Test
	public void testWhenUserLogged() {
		// JSONService jsonService = new JSONServiceImpl();
		Usuario usuarioExpected = new Usuario();
		usuarioExpected.setUsuario("oshingc");
		usuarioExpected.setPassword("123456");

		UserService userService = mock(UserService.class);
		when(userService.loginDocente(usuarioExpected)).thenReturn(usuarioExpected);
		Usuario usuarioActual = userService.loginDocente(usuarioExpected);
		assertEquals(usuarioExpected.getUsuario(), usuarioActual.getUsuario());
		assertEquals(usuarioExpected.getPassword(), usuarioActual.getPassword());

	}

}
