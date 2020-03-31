package com.reda.mapper;

import com.reda.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface TestMapper {

    @Select("select name from user where id = #{id}")
    String findNameById(Integer id);

    @Insert("insert into user(name, age) values (#{name}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User user);

    @Select("select id,name,age from user where id=#{id}")
    User findById(Integer id);
}
