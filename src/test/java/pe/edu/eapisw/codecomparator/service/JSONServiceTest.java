package pe.edu.eapisw.codecomparator.service;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import pe.edu.eapisw.codecomparator.beans.json.Codigo;
import pe.edu.eapisw.codecomparator.beans.json.Paquete;
import pe.edu.eapisw.codecomparator.beans.json.Proyecto;
import pe.edu.eapisw.codecomparator.beans.model.Usuario;
import pe.edu.eapisw.codecomparator.service.impl.JSONServiceImpl;

public class JSONServiceTest {

	private JSONService jsonService;

	@Before
	public void setUp() {
		jsonService = new JSONServiceImpl();
	}

	@Test
	public void testToJson() {
		// JSONService jsonService = new JSONServiceImpl();
		Usuario usuario = new Usuario();
		usuario.setUsuario("oshingc");
		usuario.setPassword("123456");
		String jsonExpected = "{\"usuario\":\"oshingc\",\"password\":\"123456\"}";
		String jsonActual = jsonService.toJson(usuario);
		assertEquals(jsonExpected, jsonActual);
	}

	@Test
	public void testToObject() {
		// JSONService jsonService = new JSONServiceImpl();
		Usuario usuarioExpected = new Usuario();
		usuarioExpected.setUsuario("oshingc");
		usuarioExpected.setPassword("123456");
		String json = "{\"usuario\":\"oshingc\",\"password\":\"123456\"}";
		Usuario usuarioActual = (Usuario) jsonService.toObject(json,
				Usuario.class);
		assertEquals(usuarioExpected, usuarioActual);
	}

	@Test
	public void testToJsonFromProyecto() {
		// JSONService jsonService = new JSONServiceImpl();
		Codigo codigo = new Codigo();
		codigo.setContenido("public class Foo(){" + "int foo;" + "}");
		codigo.setNombre("Foo.java");

		Paquete paquete = new Paquete();
		paquete.setNombre("foo");
		Collection<Codigo> codigos = new ArrayList<Codigo>();
		codigos.add(codigo);
		paquete.setCodigos(codigos);

		Proyecto proyecto = new Proyecto();
		proyecto.setNombre("Foo");
		Collection<Paquete> paquetes = new ArrayList<Paquete>();
		paquetes.add(paquete);
		proyecto.setPackages(paquetes);

		String jsonExpected = "{\"nombre\":\"Foo\",\"codigos\":[],\"paquetes\":[{\"nombre\":\"foo\",\"codigos\":[{\"nombre\":\"Foo.java\",\"contenido\":\"public class Foo(){int foo;}\",\"q\":null}],\"paquetes\":[]}]}";
		String jsonActual = jsonService.toJson(proyecto);

		assertEquals(jsonExpected, jsonActual);
	}

	@SuppressWarnings("resource")
	@Test
	public void foo() throws IOException {
		BufferedReader reader = new BufferedReader(
				new FileReader(
						"src/test/java/pe/edu/eapisw/codecomparator/service/JSONServiceTest.java"));
		String linea;
		String contenido = "";
		while ((linea = reader.readLine()) != null) {
			contenido += linea + "\n";
		}
		System.out.println("&" + contenido + "&");
	}
}
