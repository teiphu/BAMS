<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018.01.12
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账号管理</title>
</head>
<body>
<form id="maFormAddCust" method="post" action="/account/addAccount.action" >
    <table>
        <tr>
            <td>
                <table>
                    <tr>
                        <td>客户&nbsp;&nbsp;&nbsp;ID: <input type="text" name="customer.cid" id="cid" value="${customer.cid}"></td>
                    </tr>
                    <tr>
                        <td>余&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;额: <input type="text" value="${account.cbalance}" name="cbalance" id="cbalance"></td>
                    </tr>
                    <tr>
                        <td>限&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;额: <input type="text" value="${account.climit}" name="climit" id="climit"></td>
                    </tr>
                    <tr>
                        <td>账号类型: <input type="text" value="${account.ctype}" name="ctype" id="ctype"></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="开户"></td>
            <td><input type="reset" value="取消"></td>
        </tr>
    </table>
</form>

<form action="/account/removeAccount.action" method="post">
    <table>
        <tr>
            <td>要删除的账号ID<input type="text" name="aid" id="aid" value="${aid}"></td>
            <td><input type="submit" value="删除"></td>
        </tr>
    </table>
</form>
<form action="/toUpdateAccount.action">
    <input type="submit" value="修改账号信息">
</form>
</body>
</html>
