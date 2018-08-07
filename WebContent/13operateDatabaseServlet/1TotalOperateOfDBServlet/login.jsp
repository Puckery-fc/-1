<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>用户登录页面</title>
</head>
<body>
用户登录界面
<% String dir = request.getContextPath(); %>
<form name="form1" method="post" action="/2015javawebClassProject/UserMesaageOperateServlet?action=login">
用户名： <input	name="name" type="text" id="name" style="width: 120px"><br>
密&nbsp;&nbsp;码： <input name="pwd" type="password" id="pwd" style="width: 120px"> <br>
<br>
<input type="submit" name="Submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=dir %>/13operateDatabaseServlet/1TotalOperateOfDBServlet/registerUser.jsp">注册新用户</a>
</form>
</body>
</html>