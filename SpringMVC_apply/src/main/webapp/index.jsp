<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#ajaxBtn").bind("click", function () {
                $.ajax({
                    url: '/ajax/doAction',
                    type: 'POST',
                    contentType: 'application/json;charset=utf-8',
                    data: '{"id":"1","name":"李四","birthday":"2020-01-01"}',
                    dataType: 'json',
                    success: function (data) {
                        alert(data.id + data.name + data.birthday);
                    }
                })
            })
        })
    </script>
    <style>
        div {
            padding: 10px 10px 0 10px;
        }
    </style>
</head>
<body>
<h2>Hello World!</h2>

<div>
    <h2>SpringMVC进行文件上传</h2>
    <fieldset>
        <p>测试用例：文件上传-SpringMVC完成文件上传</p>
        <form action="/demo/upload" enctype="multipart/form-data" method="post">
            <input type="file" name="uploadFile"/>
            <input type="submit">
        </form>
    </fieldset>


    <h2>SpringMVC对Restful风格url的支持</h2>
    <fieldset>
        <p>测试用例：文件上传-servlet普通方式</p>
        <form action="/FileUploadServlet" enctype="multipart/form-data" method="post">
            <input type="text" name="username"/>
            <input type="password" name="pwd"/>
            <input type="file" name="pic"/>
            <input type="submit">
        </form>
    </fieldset>

    <fieldset>
        <p>测试用例：SpringMVC对Restful风格url的支持</p>

        <a href="/param/get1">rest_get测试</a>
        <a href="/ajax/doAction">ajax测试</a>


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

<div>
    <h2>Ajax json交互</h2>
    <fieldset>
        <input type="button" id="ajaxBtn" value="ajax提交"/>
    </fieldset>
</div>

</body>
</html>
