<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018.01.12
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查找所有的存款记录</title>
</head>
<body>
<table border="1">
    <tr>
        <th>记录ID</th><th>账号ID</th><th>记录类型</th><th>记录时间</th><th>存款额</th><th>账号余额</th>
    </tr>
    <c:forEach items="${requestScope.deposits }" var="deposit" >
        <tr>
            <td>${deposit.did}</td>
            <td>${deposit.account.aid}</td>
            <td>${deposit.dtype}</td>
            <td>${deposit.dtime}</td>
            <td>${deposit.dmoney}</td>
            <td>${deposit.dbalance}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
