<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <style>
        div {
            padding: 10px 10px 0 10px;
        }
    </style>
</head>
<body>
<h2>Hello World!</h2>
<div>
    <h2>SpringMVC对Restful风格url的支持</h2>
    <fieldset>
        <p>测试用例：SpringMVC对Restful风格url的支持</p>

        <a href="/demo/handle/15">rest_get测试</a>


        <form method="post" action="/demo/handle">
            <input type="text" name="username"/>
            <input type="submit" value="提交rest_post请求"/>
        </form>


        <form method="post" action="/demo/handle/15/lisi">
            <input type="hidden" name="_method" value="put"/> <%--SpringMVC规定, 如果被过滤器检测到有_method参数, 就会使用指定请求方式请求服务器--%>
            <input type="submit" value="提交rest_put请求"/>
        </form>

        <form method="post" action="/demo/handle/15">
            <input type="hidden" name="_method" value="delete"/>
            <input type="submit" value="提交rest_delete请求"/>
        </form>
    </fieldset>
</div>
</body>
</html>
