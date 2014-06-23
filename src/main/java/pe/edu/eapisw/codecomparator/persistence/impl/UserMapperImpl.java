package pe.edu.eapisw.codecomparator.persistence.impl;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;
import pe.edu.eapisw.codecomparator.persistence.UserMapper;

public class UserMapperImpl implements UserMapper {

	@Override
	public Usuario loginDocente(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Select(value = "SELECT cod, dsc from Usuario where ")
	 * 
	 * @Results(value = {
	 * 
	 * @Result(javaType = Usuario.class),
	 * 
	 * @Result(column = "cod",property = "usuario"),
	 * 
	 * @Result(column = "dsc",property = "password") }) public Usuario
	 * loginDocente(@Param("cod") String username, @Param("password") String
	 * password);
	 */

}
