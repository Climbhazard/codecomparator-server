package pe.edu.eapisw.codecomparator.util;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import pe.edu.eapisw.codecomparator.beans.json.Codigo;
import pe.edu.eapisw.codecomparator.beans.json.Evaluacion;
import pe.edu.eapisw.codecomparator.beans.json.Paquete;
import pe.edu.eapisw.codecomparator.beans.json.Posicion;
import pe.edu.eapisw.codecomparator.beans.json.Proyecto;
import pe.edu.eapisw.codecomparator.beans.model.Alumno;
import pe.edu.eapisw.codecomparator.beans.model.Curso;
import pe.edu.eapisw.codecomparator.beans.model.Usuario;
import pe.edu.eapisw.codecomparator.util.JSONUtil;

public class JSONUtilTest {

	private JSONUtil jsonService;

	@Before
	public void setUp() {
		jsonService = new JSONUtil();
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
	public void foo() throws IOException { // generar el json de un objeto
	// Evaluacion
		Alumno uno = new Alumno();
		uno.setN_alumno_id(1);
		uno.setT_codigo("10200196");
		uno.setT_nombre("Braulio");
		uno.setT_apellido_paterno("Sánchez");
		uno.setT_apellido_materno("Vinces");

		Alumno tres = new Alumno();
		tres.setN_alumno_id(2);
		tres.setT_codigo("10200218");
		tres.setT_nombre("Alejandra");
		tres.setT_apellido_paterno("Gómez");
		tres.setT_apellido_materno("Casani");

		// poblaremos Codigo con datos reales
		BufferedReader reader = new BufferedReader(new FileReader(
				"src/test/java/pe/edu/eapisw/codecomparator/util/Foo"));
		String linea;
		String contenido = "";
		while ((linea = reader.readLine()) != null) {
			contenido += linea + "\n";
		}

		Codigo codigo = new Codigo();
		codigo.setContenido(contenido);
		codigo.setNombre("Foo.java");
		codigo.setQ(new Double[] { 0.0, 0.0123, 0.256, 0.0, 0.145, 0.0214, 0.0,
				0.0, 0.236, 0.365, 0.258, 0.0, 0.0, 0.1, 0.154, 0.36, 0.456,
				0.0, 0.14, 0.025, 0.325 });

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

		Posicion primero = new Posicion();
		primero.setAlumno(uno);
		primero.setProyecto(proyecto);

		Posicion tercero = new Posicion();
		tercero.setAlumno(tres);
		tercero.setProyecto(proyecto);
		Collection<Posicion> matriz = new ArrayList<Posicion>();
		matriz.add(new Posicion());
		matriz.add(primero);
		matriz.add(new Posicion());
		matriz.add(tercero);
		matriz.add(new Posicion());
		for (int i = 0; i < 15; i++) {
			matriz.add(new Posicion());
		}

		Curso curso = new Curso();
		curso.setCursoId(500);
		curso.setDocente(null);
		curso.setGrupo(String.valueOf(2));
		curso.setNombre("Algorítmica II");

		Evaluacion evaluacion = new Evaluacion();
		evaluacion.setN_evaluacion_id(1);
		evaluacion.setCurso(curso.getNombre());
		evaluacion.setGrupo(String.valueOf(2));
		evaluacion.setTitulo("Punteros");
		evaluacion.setDescripcion("Una práctica muy sencilla");
		evaluacion.setTiempo("00:05:00");
		evaluacion.setFechaRegistro(new java.util.Date());
		evaluacion.setMatriz(matriz);

		System.out.println("&" + jsonService.toJson(evaluacion) + "&");
		FileWriter fw = new FileWriter(
				new File(
						"src/test/java/pe/edu/eapisw/codecomparator/persistence/Evaluacion"));
		PrintWriter pw = new PrintWriter(fw);
		pw.println(jsonService.toJson(evaluacion));
		fw.close();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		System.out.println(sdf.format(new java.util.Date(1403536835283L)));
		sdf = new SimpleDateFormat("HH:mm:ss");
		System.out.println(sdf.format(new java.util.Date(1403536835283L)));

	}
}