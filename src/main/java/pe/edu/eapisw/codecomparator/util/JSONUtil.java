package pe.edu.eapisw.codecomparator.util;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JSONUtil {

	private ObjectMapper objectMapper;

	public String toJson(Object object) {
		String json = "";
		objectMapper = new ObjectMapper();
		try {
			json = objectMapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object toObject(String json, Class clazz) {
		objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(json, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
