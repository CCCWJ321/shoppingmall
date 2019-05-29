<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="findpassword" type="mybean.Login" scope="session"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<font size=15 color=blue ><br/>
<jsp:getProperty name="findpassword" property="backNews"/>
<jsp:getProperty name="findpassword" property="password" /></br>
<a href="register.jsp">返回注册</a></br>
<a href="login.jsp">点击登录</a>
</font>
</center>
</body>
</html>