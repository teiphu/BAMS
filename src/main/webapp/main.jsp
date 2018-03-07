<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018.01.11
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
欢迎[${sessionScope.customer_session.cname}]访问<br>

<form id="mainForm" method="post" action="/customer/selectAllCustomer.action" >
    <table>
        <tr>
            <td>
                <input type="submit" value="检索所有客户">
            </td>
        </tr>
    </table>
</form>
<form id="mainFormSec" method="post" action="/customer/selectCustomer.action" >
    <table>
        <tr>
            <td>
                <input type="submit" value="查找个人客户信息">
            </td>
        </tr>
    </table>
</form>
<form id="mainFormAdd" method="post" action="/customer/addCustomer.action" >
    <table>
        <tr>
            <td>
                <table>
                    <tr>
                        <td>姓名: <input type="text" name="cname" id="cname"></td>
                    </tr>
                    <tr>
                        <td>密码: <input type="password" name="cpassword" id="cpassword"></td>
                    </tr>
                    <tr>
                        <td>电话: <input type="tel" name="cphone" id="cphone"></td>
                    </tr>
                    <tr>
                        <td>电子邮箱: <input type="email" name="cemail" id="cemail"></td>
                    </tr>
                    <tr>
                        <td>地址: <input type="text" name="caddress" id="caddress"></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="添加">
            </td>
            <td>
                <input type="reset" value="取消">
            </td>
        </tr>
    </table>
</form>
<form id="mainFormUpdate" method="post" action="/customer/skipToUpdateCustomer.action" >
    <table>
        <tr>
            <td>
                <input type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>
<form id="mainFormDelete" method="post" action="/customer/removeCustomer.action" >
    <table>
        <tr>
            <td>要删除的客户ID<input type="text" name="cid" id="cid" value="${cid}"></td>
            <td><input type="submit" value="删除"></td>
        </tr>
    </table>
</form>
<table>
    <tr>
        <td>
            <form id="mainFormSelectAllAccount" method="post" action="/account/selectAllAccount.action" >
                <input type="submit" value="检索所有账号">
            </form>
        </td>
        <td>
            <form id="mainFormSelectOneCustomerAcc" method="post" action="/account/selectAccountByCid.action">
                <input type="submit" value="查询自己的账号信息">
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form id="mainFormSelectAllDeposit" method="post" action="/deposit/selectAllDeposit.action">
                <input type="submit" value="检索所有的存款记录">
            </form>
        </td>
        <td>
            <form id="mainFormSelectAllWithdraw" method="post" action="/withdraw/selectAllWithdraw.action">
                <input type="submit" value="检索所有的取款记录">
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form id="mainFormSelectOneDeposit" method="post" action="/deposit/selectDepositByAid.action">
                <input type="submit" value="检索个人的存款记录">
            </form>
        </td>
        <td>
            <form id="mainFormSelectOneWithdraw" method="post" action="/withdraw/selectWithdrawByAid.action">
                <input type="submit" value="检索个人的取款记录">
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="/toAccountManage.action">
                <input type="submit" value="账号管理">
            </form>
        </td>
    </tr>
    <tr>
        <td>
            <form action="/toDepositManage.action">
                <input type="submit" value="存款管理">
            </form>
        </td>

        <td>
            <form action="/toWithdrawManage.action">
                <input type="submit" value="取款管理">
            </form>
        </td>
    </tr>
</table>
</body>
</html>
