package com.nengli51.mapper;

import com.nengli51.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 功能说明：单表增删改查
 * 开发人员：@author MaLi
 */
public interface IUserMapper {
    @Insert("insert into user values (null,#{username},#{sex},#{birthday},#{address})")
    void addUser(User user);

    @Delete("delete from user where uid=#{uid}")
    void deleteUser(Integer id);

    @Update("update user set username=#{username},sex=#{sex},birthday=#{birthday},address=#{address} where uid=#{uid}")
    void updateUser(User user);

    @Select("select * from user where uid=#{uid}")
    User findUser(Integer id);

    @Select("select * from user")
    List<User> findAll();
}
