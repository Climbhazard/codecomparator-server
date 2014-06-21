package pe.edu.eapisw.codecomparator.persistence;

import java.util.Locale;

import com.dropbox.core.DbxAuthInfo;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonReader.FileLoadException;

public class DropboxUploaderImpl implements DropboxUploader {

	@Override
	public void upload(String srcFilename, String destFilename) {
		// TODO Auto-generated method stub

	}

	@Override
	public DbxClient createDbxClient(String authTokenFile)
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
