<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018.01.12
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>取款管理</title>
</head>
<body>
<h2>取款</h2>
<form id="maFormAddWith" method="post" action="/withdraw/addWithdraw.action" >
    <table>
        <tr>
            <td>
                <table>
                    <tr>
                        <td>账号ID: <input type="text" name="aid" id="aid" value="${aid}"></td>
                    </tr>
                    <tr>
                        <td>取款额: <input type="text" value="${withdraw.wmoney}" name="wmoney" id="wmoney"></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="取款"></td>
            <td><input type="reset" value="取消"></td>
        </tr>
    </table>
</form>
</body>
</html>
