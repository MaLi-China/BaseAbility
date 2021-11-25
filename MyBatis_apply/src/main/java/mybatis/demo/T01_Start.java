package mybatis.demo;

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
import java.util.List;

/**
 * 功能说明：MyBatis Starter
 * 开发人员：@author MaLi
 */
public class T01_Start {
    private SqlSession sqlSession = null;

    @Before
    public void init() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis_cfg.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryUser() {
        // 通过命名空间 + StatementID 直接执行SQL并获取到结果集(内部封装JDBC代码)
        List<User> userList = sqlSession.selectList("userMapper.findAll"); //还是存在耦合
            /*
            原理剖析:
                SqlSession通过执行接口内方法;
                执行参数指向的SQL;
             */
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void addUser() {
        User user = new User(4, "Mark4");
        int insert = sqlSession.insert("userMapper.addUser", user);
        System.out.println(insert);
        sqlSession.commit();
    }

    @Test
    public void deleteUser() {
        int delete = sqlSession.delete("userMapper.deleteUser", 4);
        sqlSession.commit();
        System.out.println(delete);
    }

    @Test
    public void updateUser() {
        User user = new User(3, "Javaer");
        int update = sqlSession.update("userMapper.updateUser", user);
        sqlSession.commit();
        System.out.println(update);
    }


    @After
    public void finallyDo() {
        sqlSession.close();
    }


}
