package pe.edu.eapisw.codecomparator.service;

import static org.junit.Assert.*;

import org.junit.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import pe.edu.eapisw.codecomparator.beans.model.Docente;
import pe.edu.eapisw.codecomparator.beans.model.Usuario;

public class UserServiceTest {

	@Before
	public void setUp() {
		// userService = new UserServiceImpl();
	}

	@Test
	public void testWhenUserLogged() {
		// JSONService jsonService = new JSONServiceImpl();

		Usuario usuario = new Usuario();

		Docente docenteExpected = new Docente();
		docenteExpected.setCodigo("D010203");
		docenteExpected.setDocenteId(String.valueOf(10));
		docenteExpected.setNombre("Braulio");

		usuario.setDocente(docenteExpected);
		usuario.setUsuario("braulio");
		usuario.setPassword("123qwe/");

		CuentaService cuentaService = mock(CuentaService.class);
		when(cuentaService.loginDocente(usuario)).thenReturn(docenteExpected);
		Docente docenteActual = cuentaService.loginDocente(usuario);
		assertEquals(usuario.getDocente().getDocenteId(),
				docenteActual.getDocenteId());

	}

}
