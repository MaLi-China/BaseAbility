package com.nengli51.mapper;

import com.nengli51.domain.User;

import java.util.List;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public interface UserDao {
    User query(Integer uid);

    List<User> queryAll();

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Integer uid);

}
