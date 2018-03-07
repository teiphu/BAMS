<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018.01.11
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找客户详情</title>
</head>
<body>
<table border="1">
    <tr>
        <th>客户ID</th><th>客户名字</th><th>客户电话</th><th>客户邮箱</th><th>客户地址</th><th>开户时间</th>
    </tr>
    <tr>
        <td>${requestScope.customer.cid}</td>
        <td>${requestScope.customer.cname}</td>
        <td>${requestScope.customer.cphone}</td>
        <td>${requestScope.customer.cemail}</td>
        <td>${requestScope.customer.caddress}</td>
        <td>${requestScope.customer.createdate}</td>
    </tr>
</table>

</body>
</html>
