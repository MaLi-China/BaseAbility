package spring.ioc.xml.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.xml.bean.Account;

/**
 * 功能说明：JavaSE获取Bean的方式
 * 开发人员：@author MaLi
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Account account = (Account) context.getBean("account");
        System.out.println(account);


    }
}
