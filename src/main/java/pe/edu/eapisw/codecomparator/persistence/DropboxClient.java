package pe.edu.eapisw.codecomparator.persistence;

import java.io.IOException;

public interface DropboxClient {

	/**
	 * Env�a el contenido de <code>srcFileName</code> a Dropbox seg�n la ruta
	 * definida en <code>destFilename</code>.
	 * 
	 * @param authToken
	 *            archivo que contiene el token de acceso al repositorio
	 *            Dropbox.
	 * @param srcFilename
	 * @param destFilename
	 *            ruta que puede crear carpetas, pero necesariamente describe a
	 *            un archivo de destino.<br/>
	 *            ie: <i>/codecomparator-server/another-directory/file.json</i>
	 * @throws IOException
	 */
	public void upload(String authToken, String srcFilename, String destFilename);

	/**
	 * Descarga el contenido de <code>srcFilename</code> a un archivo temporal.
	 * 
	 * @param authToken
	 *            archivo que contiene el token de acceso al repositorio
	 *            Dropbox.
	 * @param srcFilename
	 *            ruta del archivo almacenado en
	 *            <code>codecomparator-server</code>.
	 * @param destFilenameTemp
	 *            localizaci�n temporal del contenido a descagar del
	 *            repositorio.
	 * @return contenido de <code>srcFilename</code>.
	 */
	public String download(String authToken, String srcFilename);

	/**
	 * Crea un nuevo folder en Dropbox
	 * 
	 * @param authToken
	 * @param path
	 *            ruta del folder a crear dentro de Dropbox
	 */
	public void createFolder(String authToken, String path);
}
