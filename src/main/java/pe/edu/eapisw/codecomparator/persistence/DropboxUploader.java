package pe.edu.eapisw.codecomparator.persistence;

import com.dropbox.core.DbxClient;
import com.dropbox.core.json.JsonReader.FileLoadException;

public interface DropboxUploader {

	public void upload(String srcFilename, String destFilename);

	public DbxClient createDbxClient(String authTokenFile)
			throws FileLoadException;

}
