<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018.01.12
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改客户信息</title>
</head>
<body>

<form id="updateCustomerForm" method="post" action="/customer/updateCustomer.action" >
    <table>
        <tr>
            <td>
                <input type="text" name="cid" value="${customer.cid }">
                <table>
                    <tr>
                        <td>姓名: <input type="text" name="cname" value="${customer.cname }" id="cname"></td>
                    </tr>
                    <tr>
                        <td>密码: <input type="password" name="cpassword" value="${customer.cpassword }" id="cpassword"></td>
                    </tr>
                    <tr>
                        <td>电话: <input type="tel" name="cphone" value="${customer.cphone }" id="cphone"></td>
                    </tr>
                    <tr>
                        <td>电子邮箱: <input type="email" name="cemail" value="${customer.cemail }" id="cemail"></td>
                    </tr>
                    <tr>
                        <td>地址: <input type="text" name="caddress" value="${customer.caddress }" id="caddress"></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>


</body>
</html>
