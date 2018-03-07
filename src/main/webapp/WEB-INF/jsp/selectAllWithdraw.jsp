<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018.01.12
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找所有的取款记录</title>
</head>
<body>
<table border="1">
    <tr>
        <th>记录ID</th><th>账号ID</th><th>记录类型</th><th>记录时间</th><th>取款额</th><th>账号余额</th>
    </tr>
    <c:forEach items="${requestScope.withdraws }" var="withdraw" >
        <tr>
            <td>${withdraw.wid}</td>
            <td>${withdraw.account.aid}</td>
            <td>${withdraw.wtype}</td>
            <td>${withdraw.wtime}</td>
            <td>${withdraw.wmoney}</td>
            <td>${withdraw.wbalance}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
