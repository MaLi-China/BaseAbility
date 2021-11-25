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
import java.util.List;

/**
 * 功能说明：动态SQL
 * 开发人员：@author MaLi
 */
public class T03_DynamicSQL {
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
    public void testQueryByCondition() {
        User user = new User(1, null);
        List<User> users = userDao.findByCondition(user);
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testQueryByIds() {
        int[] arr = {1, 2, 3};
        List<User> users = userDao.findUserByIds(arr);
        for (User user : users) {
            System.out.println(user);
        }
    }


}
