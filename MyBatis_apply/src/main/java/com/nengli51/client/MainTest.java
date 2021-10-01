package com.nengli51.client;

import com.nengli51.domain.Orders;
import com.nengli51.domain.User;
import com.nengli51.mapper.IUserMapper;
import com.nengli51.mapper.OrdersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class MainTest {
    IUserMapper mapper;
    SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis_cfg.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sessionFactory.openSession();
        mapper = sqlSession.getMapper(IUserMapper.class);
    }

    @After
    public void end() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testAdd() {
        User user = new User();
        user.setUsername("Mark_test");
        user.setAddress("Address_test");
        user.setBirthday(new Date(System.currentTimeMillis()));
        user.setSex("Male");
        mapper.addUser(user);
    }

    @Test
    public void testDelete() {
        mapper.deleteUser(12);
    }

    @Test
    public void testUpdate() {
        User user = mapper.findUser(12);
        user.setUsername("New Mark");
        mapper.updateUser(user);
    }

    @Test
    public void testFindAll() {
        List<User> allUser = mapper.findAll();
        for (User user : allUser) {
            System.out.println(user);
        }
    }


    public static void main(String[] args) {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis_cfg.xml");
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sessionFactory.openSession();
//            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
            Orders orders = mapper.findOne(2);

            System.out.println(orders);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
