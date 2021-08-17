package com.nengli51.client;

import com.nengli51.domain.User;
import com.nengli51.mapper.UserDao;
import org.apache.ibatis.io.Resources;
import org.junit.Test;

import java.io.IOException;
import java.sql.Date;

/**
 * 功能说明：
 * 开发人员：@Author MaLi
 */
public class MainTest {
    public static void main(String[] args) throws IOException {


        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis_cfg.xml"));
        SqlSession session = factory.openSession();
        UserDao dao = session.getMapper(UserDao.class);

        User user = dao.query(2);
        System.out.println(user);
//        User user = session.selectOne("user.query", 1);
        System.out.println(user);

        /*
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        try {
            SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis_cfg.xml"));
            SqlSession sqlSession = factory.openSession();
            UserDao userDao = sqlSession.getMapper(UserDao.class);
            User user = sqlSession.selectOne("query",1);
            System.out.println(user);

//            User user = userDao.query(1);
//            System.out.println(user);
//            List<User> users = userDao.queryAll();
//            for (User u : users) {
//                System.out.println(u);
//            }
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @Test
    public void testMethod1() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(Resources.getResourceAsReader("mybatis_cfg.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        User user = dao.query(1);
        System.out.println(user);
    }

    @Test
    public void testMethod2() throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis_cfg.xml"));
        SqlSession sqlSession = factory.openSession();
        User user = new User();
        user.setSex("male");
        user.setAddress("Bejing");
        user.setBirthday(new Date(new java.util.Date().getTime()));
        user.setUsername("Mark");
        sqlSession.insert("addUser", user);
        sqlSession.commit();


        UserDao dao = sqlSession.getMapper(UserDao.class);
        dao.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testMethod3() throws IOException {

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis_cfg.xml"));
        SqlSession sqlSession = factory.openSession(true);
        User user = new User();
        user.setSex("female");
        user.setAddress("BejingChaoyang");
        user.setBirthday(new Date(new java.util.Date().getTime()));
        user.setUsername("Mark Tom Jim LiLei");
        user.setUid(9);
        sqlSession.update("updateUser", user);
        sqlSession.close();

    }

    @Test
    public void testMethod4() throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis_cfg.xml"));
        SqlSession sqlSession = factory.openSession(true);

        sqlSession.delete("deleteUser", 1);

        sqlSession.close();
    }


    @Test
    public void testMethod_nameSpace() throws IOException {

    }

}
