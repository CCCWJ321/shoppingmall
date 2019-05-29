<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="register" type="mybean.Register" scope="request"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功</title>
</head>

<body bgcolor=yellow>
<table>
<tr><td><a href="register.jsp">用户注册</a></td></tr>
<tr><td><a href="login.jsp">用户登录</a></td></tr>
</table>
<font size=4 color=blue ><br/>
<jsp:getProperty name="register" property="backNews"/>
</font>
<center>
<table>
<tr>
<td>注册的名称:</td>
<td><jsp:getProperty name="register" property="logname"/></td>
</tr>
<tr>
<td>注册的电子邮件:</td>
<td><jsp:getProperty name="register" property="email"/></td>
</tr>
</table>
</center>
</body>
</html>