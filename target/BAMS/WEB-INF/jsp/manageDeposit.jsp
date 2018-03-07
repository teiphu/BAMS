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
    <title>存款管理</title>
</head>
<body>
<h2>存款</h2>
    <form id="maFormAddDep" method="post" action="/deposit/addDeposit.action" >
        <table>
            <tr>
                <td>
                    <table>
                        <tr>
                            <td>账号ID: <input type="text" name="aid" id="aid" value="${aid}"></td>
                        </tr>
                        <tr>
                            <td>存款额: <input type="text" value="${deposit.dmoney}" name="dmoney" id="dmoney"></td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="存款"></td>
                <td><input type="reset" value="取消"></td>
            </tr>
        </table>
    </form>

</body>
</html>
