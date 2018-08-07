 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
 <script type="text/javascript">
        function b1_onclick()
        {
            if(b1.innerText=="+")
            {
                document.body.all("b1").innerText="-";
                list1.style.display="block";
            }
            else
            {
                document.body.all("b1").innerText="+";
                list1.style.display="none";
            }

        }
        </script>
</head>
<body>
<div id="logo" style="height:200px; background-image:url(logo.jpg)"></div>
<div id="middle"></div>
<div id="left" style="width:20%; height:450px; border:#000 medium groove; background-color:#BFBFBF; float:left;">
<span id="b1" style="border: thin ridge; cursor: pointer" onclick=" return b1_onclick()">+</span>用户信息管理<br>
<ul id="list1" >
    <li><a href="javascript:void(0)" onClick="document.getElementById('main').src='login.jsp'">登录用户</a></li>
    <li><a href="javascript:void(0)" onClick="document.getElementById('main').src='registerUser.jsp'">注册用户</a></li>
    <li ><a href="javascript:void(0)" onClick="document.getElementById('main').src='DeleteUser.jsp'">删除用户</a></li>
    <li ><a href="javascript:void(0)" onClick="document.getElementById('main').src='UpdateUser.jsp'" >修改用户信息</a></li>
      <li ><a href="javascript:void(0)" onClick="document.getElementById('main').src='tianjia.jsp'" >添加</a></li>
    <li ><a href="javascript:void(0)" onClick="document.getElementById('main').src='/2015javawebClassProject/UserMesaageOperateServlet?action=select'">查询所有用户信息</a></li>
</ul>
</div>
<div id="right" style="width:78%; height:450px; border:#000 medium groove; float:right;">
<iframe id="main" style="width:100%; height:100%;"></iframe>
</div>
<div id="footer" style="width:100%; height:45px; border:#000 medium groove; text-align:center; float:left;" >技术支持：Java Web软件组<br>电话：15088558058</div>


</body>
</html>