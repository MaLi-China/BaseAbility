package com.nengli51.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能说明：
 * 开发人员：@author MaLi
 */
@WebServlet(name = "TestServlet", value = "/TestServlet")
public class TestBaseServletAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("Chinese中文输出");


        //方式1: 获取的根目录
        // /D:/Source/java/BaseAbility/SpringMVC_apply/target/classes/
        String path1 = TestBaseServletAPI.class.getClassLoader().getResource("").getPath();

        // 方式2: 获取的根目录
        // /D:/Source/java/BaseAbility/SpringMVC_apply/target/classes/
        String path2 = TestBaseServletAPI.class.getClassLoader().getResource(".").getPath();

        // 方式3: 当前包下
        // /D:/Source/java/BaseAbility/SpringMVC_apply/target/classes/com/nengli51/servlet/
        String path3 = TestBaseServletAPI.class.getResource(".").getPath();

        // 方式4: 获取根目录
        // /D:/Source/java/BaseAbility/SpringMVC_apply/target/classes/
        String path4 = TestBaseServletAPI.class.getResource("/").getPath();

        // D:\Source\java\BaseAbility\SpringMVC_apply\src\main\webapp\
        String path = getServletContext().getRealPath("/");
    }
}
