package pe.edu.eapisw.codecomparator.persistence;

//import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import pe.edu.eapisw.codecomparator.persistence.impl.DropboxUploaderImpl;

public class DropboxUploaderTest {

	private DropboxUploader dropboxUploader;
	private String authTokenFile;

	@Before
	public void setUp() {
		dropboxUploader = new DropboxUploaderImpl();
		authTokenFile = "src/test/java/pe/edu/eapisw/codecomparator/persistence/auth-file-output";
	}

	@Test
	public void testUpload() {
		String srcFilename = "src/test/java/pe/edu/eapisw/codecomparator/persistence/upload-file-src";
		String destFilename = "/test/testUpload";
		dropboxUploader.upload(authTokenFile, srcFilename, destFilename);
	}

	@Test
	public void testDownload() {
		String srcFilename = "/test/testUpload";
		String destFilenameTemp = "src/test/java/pe/edu/eapisw/codecomparator/persistence/";
		System.out.println("&"
				+ dropboxUploader.download(authTokenFile, srcFilename,
						destFilenameTemp) + "&");
	}

	@Test
	public void foo() throws IOException {
		String temp = "src/test/java/pe/edu/eapisw/codecomparator/persistence/hola";
		java.io.File file = new java.io.File(temp);
		System.out.println(file.exists());
		file.createNewFile();
		System.out.println(file.exists());
		file.delete();
		System.out.println(file.exists());
	}

}
