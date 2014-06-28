package pe.edu.eapisw.codecomparator.persistence.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

import org.springframework.stereotype.Component;

import pe.edu.eapisw.codecomparator.persistence.DropboxClient;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;
import com.dropbox.core.json.JsonReader.FileLoadException;

@Component("dropboxClient")
public class DropboxClientImpl implements DropboxClient {

	// private DbxClient dbxClient;

	@Override
	public void upload(String authTokenFile, String srcFilename,
			String destFilename) {

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
			// dbxClient = createDbxClient(authTokenFile);
			createDbxClient(authTokenFile)/* dbxClient */.uploadFile(targetPath,
					DbxWriteMode.add(), uploadFile.length(), uploadFIS);
		}

		catch (DbxException e) {
			e.printStackTrace();
			try {
				uploadFIS.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.err.println("Error in upload(): " + e.getMessage());
			System.exit(1);
			return;
		} catch (FileLoadException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private DbxClient createDbxClient(String authToken)
			throws FileLoadException {

		// Create a DbxClient, which is what you use to make API calls.
		String userLocale = Locale.getDefault().toString();
		DbxRequestConfig requestConfig = new DbxRequestConfig("DbxUploader",
				userLocale);
		DbxHost host = new DbxHost("api.dropbox.com",
				"api-content.dropbox.com", "www.dropbox.com");
		return new DbxClient(requestConfig, authToken, host);
	}

	@SuppressWarnings("resource")
	@Override
	public String download(String authToken, String srcFilename) {
		String temp = System.getProperty("java.io.tmpdir")
				+ System.getProperty("file.separator")
				+ String.valueOf(Math.random());
		String content = "";
		FileOutputStream fos;
		try {
			File fileTemp = new File(temp);
			fileTemp.createNewFile();
			fos = new FileOutputStream(temp);
			createDbxClient(authToken).getFile(srcFilename, null, fos);
			BufferedReader reader = new BufferedReader(new FileReader(temp));
			String line;
			while ((line = reader.readLine()) != null) {
				content += line + "\n";
			}
			fos.close();
			fileTemp.delete();
		} catch (DbxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FileLoadException e) {
			e.printStackTrace();
		}
		return content;
	}

	@Override
	public void createFolder(String authToken, String path) {
		try {
			createDbxClient(authToken).createFolder(path);
		} catch (DbxException e) {
			e.printStackTrace();
		} catch (FileLoadException e) {
			e.printStackTrace();
		}
	}

}
