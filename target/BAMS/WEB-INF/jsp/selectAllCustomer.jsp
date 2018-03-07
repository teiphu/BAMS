<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018.01.11
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找所有客户</title>
</head>
<body>
<table border="1">
    <tr>
        <th>客户ID</th><th>客户名字</th><th>客户电话</th><th>客户邮箱</th><th>客户地址</th><th>开户时间</th>
    </tr>
    <c:forEach items="${requestScope.customer_list }" var="customer" >
        <tr>
            <td>${customer.cid}</td>
            <td>${customer.cname}</td>
            <td>${customer.cphone}</td>
            <td>${customer.cemail}</td>
            <td>${customer.caddress}</td>
            <td>${customer.createdate}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
