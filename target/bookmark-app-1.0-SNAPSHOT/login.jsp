<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 08.05.2020
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>
<body>
<div style="height:65px;align: center;background: #DB5227;font-family: Arial;color: white;">
<br><b>
    <a href="" style="font-family:garamond;font-size:34px;margin:0 0 0 10px;color:white;text-decoration: none;">bookmark-app</a></b>
</div>
<br><br>
<form method="POST" action="<%=request.getContextPath()%>/auth">
    <fieldset>
        <legend>Log In</legend>
        <table>
            <tr>
                <td><label>Email:</label></td>
                <td>
                    <input type="text" name="email"><br>
                </td>
            </tr>
            <tr>
                <td><label>Password:</label></td>
                <td>
                    <input type="password" name="password"><br>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" name="submitLoginForm" value="Log In"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
