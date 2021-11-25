package mybatis.demo;

import mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;

/**
 * 功能说明：使用接口的方式
 * 开发人员：@author MaLi
 */
public class T02_Start {
    private SqlSession sqlSession = null;
    private UserMapper userDao = null;

    @Before
    public void init() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_cfg.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sessionFactory.openSession();
            userDao = sqlSession.getMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void finallyDo() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser() {
        userDao.addUser(new User(null, "who"));
    }

    @Test
    public void deleteUser() {
        userDao.deleteUser(4);

    }

    @Test
    public void update() {
        userDao.updateUser(new User(3, "MarkUpdate"));
    }

    @Test
    public void query() {
        User user = userDao.findOne(3);
        System.out.println(user);
    }
}
