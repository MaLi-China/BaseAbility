package spring.ioc.annotation.controller;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import spring.ioc.xml.bean.Account;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
@WebServlet(name = "MainTestServlet", value = "/MainTestServlet")
public class MainTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        Account account = (Account) context.getBean("account");
        System.out.println(account);
    }
}
