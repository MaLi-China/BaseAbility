package mybatis.mapper;

import pojo.User;

import java.util.List;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public interface UserMapper {
    void addUser(User user);

    void deleteUser(int id);

    void updateUser(User user);

    User findOne(int id);

    List<User> findAll();

    List<User> findByCondition(User user);

    List<User> findUserByIds(int[] ids);
}
