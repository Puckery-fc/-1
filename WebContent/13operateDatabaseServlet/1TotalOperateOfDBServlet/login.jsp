<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>�û���¼ҳ��</title>
</head>
<body>
�û���¼����
<% String dir = request.getContextPath(); %>
<form name="form1" method="post" action="/2015javawebClassProject/UserMesaageOperateServlet?action=login">
�û����� <input	name="name" type="text" id="name" style="width: 120px"><br>
��&nbsp;&nbsp;�룺 <input name="pwd" type="password" id="pwd" style="width: 120px"> <br>
<br>
<input type="submit" name="Submit" value="��¼">&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=dir %>/13operateDatabaseServlet/1TotalOperateOfDBServlet/registerUser.jsp">ע�����û�</a>
</form>
</body>
</html>