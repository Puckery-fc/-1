<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>修改用户信息</title>
</head>
<body>
修改用户信息界面
<form name="form1" method="post" action="/2015javawebClassProject/UserMesaageOperateServlet?action=update">
请输入旧用户名： <input	name="nameOld" type="text" id="name" style="width: 120px"><br>
请输入新用户名： <input	name="nameNew" type="text" id="name" style="width: 120px"><br>
请输入新密码： <input name="pwdNew" type="password" id="pwd" style="width: 120px"> <br>
<br>
<input type="submit" name="Submit" value="提交">
</form>
</body>
</html>