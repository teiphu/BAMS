<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018.01.12
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改账号</title>
</head>
<body>
<form method="post" action="/account/updateAccount.action" >
    <table>
        <tr>
            <td>
                账号ID: <input type="text" name="aid" value="${account.aid }">
                <table>
                    <tr>
                        <td>客户&nbsp;&nbsp;&nbsp;ID: <input type="text" name="cid" value="${customer.cid }" id="cid"></td>
                    </tr>
                    <tr>
                        <td>余&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;额: <input type="text" name="cbalance" value="${account.cbalance }" id="cbalance"></td>
                    </tr>
                    <tr>
                        <td>限&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;额: <input type="text" name="climit" value="${account.climit }" id="climit"></td>
                    </tr>
                    <tr>
                        <td>账号类型: <input type="email" name="ctype" value="${account.ctype }" id="ctype"></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="修改"></td>
            <td><input type="reset" value="取消"></td>
        </tr>
    </table>
</form>

</body>
</html>
