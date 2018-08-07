<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="java.util.ArrayList,com.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%ArrayList<User> list = (ArrayList<User>)session.getAttribute("userlist"); 

%>

<table width="450"border="1">
<tr><td align="center"colspan="2"><h2>所有用户信息表</h2></td></tr>
<tr><td>用户名</td><td>密码</td></tr>
<%
//for(User user:list)
	for(int i=0;i<list.size();i++){
	User u1 = list.get(i);
	%>
	<tr>
	<td><%=u1.userName %></td>
	<td><%=u1.userPassword %></td>
	</tr>
	<%

	}
%>


</table>

</body>
</html>