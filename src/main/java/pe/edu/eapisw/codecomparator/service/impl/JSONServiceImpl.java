package pe.edu.eapisw.codecomparator.service.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import pe.edu.eapisw.codecomparator.service.JSONService;

public class JSONServiceImpl implements JSONService {

	private ObjectMapper objectMapper;

	@Override
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
	@Override
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
