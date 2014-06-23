package pe.edu.eapisw.codecomparator.persistence.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;
import pe.edu.eapisw.codecomparator.persistence.UserMapper;
import pe.edu.eapisw.codecomparator.persistence.DropboxUploader;

import com.dropbox.core.DbxAuthInfo;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonReader.FileLoadException;

public class UserMapperImpl implements UserMapper {

	@Override
	public Usuario loginDocente(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}


	 /*@Select(value = "SELECT cod, dsc from Usuario where ")
	 @Results(value = {
	            @Result(javaType = Usuario.class),
	            @Result(column = "cod",property = "usuario"),
	            @Result(column = "dsc",property = "password")
	 })
	 public Usuario loginDocente(@Param("cod") String username, @Param("password") String password);*/
		
	
}
