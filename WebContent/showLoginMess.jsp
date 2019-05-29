<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="login" type="mybean.Login" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
<center>
<a href="showBook.jsp">点击查看图书</a>
</center>
<img alt="图书" src="image/timg.jpg" width=100% height=100%>

<%--  <center>
 <font size=50 color=blue >
 <br/><jsp:getProperty name="login" property="backNews"/>
 </font>
<font size=50 color=cyan>
<% if(login.isSuccess()==true) {
%> <br/>
登录名称:<jsp:getProperty name="login" property="loginame"/>
<% } else { 
%><br/>
登录名称:<jsp:getProperty name="login" property="loginame"/><br/>
 登录密码:<jsp:getProperty name="login" property="password"/> <% }
%>
</font>
<br/>--%>

</body>
</html>