package pe.edu.eapisw.codecomparator.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import pe.edu.eapisw.codecomparator.beans.model.Usuario;

public interface UserMapper {

	@Select("SELECT * FROM usuario WHERE usuario= #{username} and t_password = #{password}")
    @Results(value =  {
            @Result(javaType = Usuario.class),
            @Result(column = "t_usuario",property = "usuario"),
            @Result(column = "t_password",property = "password")
    })
	public Usuario loginDocente(Usuario usuario);
	
	@Insert("INSERT INTO usuario (t_usuario, t_password) VALUES (#{usuario},#{password})")
    public int crearCuentaDocente(Usuario usuario);

}
