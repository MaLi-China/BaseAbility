package com.nengli51.client;

import com.nengli51.domain.Orders;
import com.nengli51.mapper.OrdersMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
public class MainTest {
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
