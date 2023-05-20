package com.example.supermarket.mapper;


import com.example.supermarket.bean.AuthUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    AuthUser getPasswordByUsername(String username);

    @Options(useGeneratedKeys = true,keyColumn = "uid",keyProperty = "uid")
    @Insert("insert into user(username,password,role) values(#{username},#{password},#{role})")
    int registerUser(AuthUser user);
}
