<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>删除用户</title>
</head>
<body>
删除用户
<form name="form1" method="post" action="/2015javawebClassProject/UserMesaageOperateServlet?action=delete">
请输入需要删除的用户名： <input	name="name" type="text" id="name" style="width: 120px"><br>
<br>
<input type="submit" name="Submit" value="删除">
</form>
</body>
</html>