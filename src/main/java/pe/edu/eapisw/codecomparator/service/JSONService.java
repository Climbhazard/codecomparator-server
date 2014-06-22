package pe.edu.eapisw.codecomparator.service;

public interface JSONService {

	public String toJson(Object object);

	@SuppressWarnings("rawtypes")
	public Object toObject(String json, Class clazz);
}
