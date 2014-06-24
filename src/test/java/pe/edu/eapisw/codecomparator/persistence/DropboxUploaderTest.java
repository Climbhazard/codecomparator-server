package pe.edu.eapisw.codecomparator.persistence;

//import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import pe.edu.eapisw.codecomparator.persistence.impl.DropboxClientImpl;

public class DropboxUploaderTest {

	private DropboxClient dropboxUploader;
	private String authToken;

	@Before
	public void setUp() {
		dropboxUploader = new DropboxClientImpl();
		authToken = "Ns9nnNqlFpIAAAAAAAAABan7kFFoWTdnaddpwnxh_8DMeMHrBX1PORlMrPs2qGo6";
	}

	@Test
	public void testUploadAnEvaluacion() {
		String srcFilename = "src/test/java/pe/edu/eapisw/codecomparator/persistence/Evaluacion";
		String docenteId = "/D010203";
		String nombreCurso = "/Algorítmica II";
		String evaluacionId = "/" + String.valueOf(1);
		String destFilename = docenteId + nombreCurso + evaluacionId + ".json";
		dropboxUploader.upload(authToken, srcFilename, destFilename);
	}

	@Test
	public void testDownloadAnEvaluacion() {
		String docenteId = "/D010203";
		String nombreCurso = "/Algorítmica II";
		String evaluacionId = "/" + String.valueOf(1);
		String srcFilename = docenteId + nombreCurso + evaluacionId;
		System.out.println("&"
				+ dropboxUploader.download(authToken, srcFilename) + "&");
	}

	@Test
	public void foo() throws IOException {
		String temp = "src/test/java/pe/edu/eapisw/codecomparator/persistence/"
				+ String.valueOf(Math.random());
		java.io.File file = new java.io.File(temp);
		System.out.println(file.exists());
		file.createNewFile();
		System.out.println(file.exists());
		file.delete();
		System.out.println(file.exists());
	}

	@Test
	public void foo2() {
		System.out.println(System.getProperty("java.io.tmpdir"));
		System.out.println(System.getProperty("file.separator"));
	}

}
