package pe.edu.eapisw.codecomparator.persistence.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

import pe.edu.eapisw.codecomparator.persistence.DropboxUploader;

import com.dropbox.core.DbxAuthInfo;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonReader.FileLoadException;

public class DropboxUploaderImpl implements DropboxUploader {

	private DbxClient dbxClient;

	@Override
	public void upload(String authTokenFile, String srcFilename,
			String destFilename) throws IOException {

		File uploadFile = new File(srcFilename);
		FileInputStream uploadFIS;
		try {
			uploadFIS = new FileInputStream(uploadFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			System.err.println("Error in upload(): problem opening "
					+ srcFilename);
			return;
		}

		String targetPath = destFilename;
		try {
			dbxClient = createDbxClient(authTokenFile);
			dbxClient.uploadFile(targetPath,
					DbxWriteMode.add(), uploadFile.length(), uploadFIS);
		}

		catch (DbxException e) {
			e.printStackTrace();
			uploadFIS.close();
			System.err.println("Error in upload(): " + e.getMessage());
			System.exit(1);
			return;
		} catch (FileLoadException e) {
			e.printStackTrace();
		}
	}

	private DbxClient createDbxClient(String authTokenFile)
			throws FileLoadException {
		DbxAuthInfo authInfo;
		try {

			authInfo = DbxAuthInfo.Reader.readFromFile(authTokenFile);
		} catch (JsonReader.FileLoadException ex) {
			System.err
					.println("Error in DbxUploader constructor: problem loading <auth-file>: "
							+ ex.getMessage());
			throw ex;
		}

		// Create a DbxClient, which is what you use to make API calls.
		String userLocale = Locale.getDefault().toString();
		DbxRequestConfig requestConfig = new DbxRequestConfig("DbxUploader",
				userLocale);
		return new DbxClient(requestConfig, authInfo.accessToken, authInfo.host);
	}

}
