<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018.01.11
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<div style="height: 100%; text-align: center">
    <div style="width: 100%; text-align: center">
        <form class="form" action="/login.action" method="post" id="loginForm">
            登录名: <input type="text" name="cname" id="cname" value="${cname}"><br>
            密&nbsp;&nbsp;&nbsp;码: <input type="password" name="cpassword" id="cpassword" value="${cpassword}"><br>
            <button type="submit" id="login-submit-btn">登录</button>
            <button type="reset">重置</button>

        </form>
    </div>

</div>

</body>
</html>
