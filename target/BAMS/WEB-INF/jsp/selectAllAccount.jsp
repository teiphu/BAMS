<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018.01.12
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找所有的账号</title>
</head>
<body>
<table border="1">
    <tr>
        <th>账号ID</th><th>客户ID</th><th>账号余额</th><th>账号限额</th><th>账号类型</th>
    </tr>
    <c:forEach items="${requestScope.accounts }" var="account" >
        <tr>
            <td>${account.aid}</td>
            <td>${account.customer.cid}</td>
            <td>${account.cbalance}</td>
            <td>${account.climit}</td>
            <td>${account.ctype}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
