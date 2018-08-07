<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>用户注册</title>
</head>
<body>
用户注册界面
<form name="form1" method="post" action="/2015javawebClassProject/UserMesaageOperateServlet?action=register">
用户名： <input	name="name" type="text" id="name" style="width: 120px"><br>
密&nbsp;&nbsp;码： <input name="pwd" type="password" id="pwd" style="width: 120px"> <br>
<br>
<input type="submit" name="Submit" value="注册">
</form>
</body>
</html>