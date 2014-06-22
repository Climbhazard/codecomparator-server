package pe.edu.eapisw.codecomparator.persistence;

import java.io.IOException;

public interface DropboxUploader {

	public void upload(String authTokenFile, String srcFilename,
			String destFilename) throws IOException;

}
