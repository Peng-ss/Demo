<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bean.JsonData"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Hero 注册界面</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

</head>
<body>
<div id="Layer1"
		style="position: absolute; width: 100%; height: 100%; z-index: -1; background-position: center; background-repeat: no-repeat; background-attachment: fixed;">
		<img src="img/register.jpg" width="100%" height="100%" />
	</div>
	<%
		JsonData jsonData = (JsonData) request.getAttribute("jsonData");
		if (jsonData != null && jsonData.getResult() == false) {
	%>
	<script>
		window.alert("你注册的用户已存在！")
	</script>
	<%
		}
	%>
		<br> <br>

		<h1 style="margin-left:800px;">用户注册</h1>
		<br> <br> <br>
		<div style="margin-left:740px;">
			<form action="/register" method="get" >
			用&nbsp;&nbsp;户&nbsp;&nbsp;名&nbsp;： <input type="text" name="userName" placeholder="请输入账号" style="width: 150px; background-color:transparent;"> <br> <br>
			用户&nbsp;密码： <input type="password" name="password" placeholder="请输入密码" style="width: 150px; background-color:transparent;"> <br> <br>
			用户&nbsp;等级： <select
				style="width: 150px; background: transparent; color: #000"
				name="level">
				<option value="1">普通用户</option>
				<option value="2">VIP用户</option>
				<option value="3">管理员</option>
			</select> <br>
			<br> <a href="login.jsp"><input type="button" value="返回" style=" margin-left:30px;width:80px;height :30px;background-color:transparent;font-size:15px;color:#000;"></a>
			<input type="submit" value="注册" style="width:80px;height :30px;background-color:transparent;font-size:15px;color:#000;">
		</form>
		</div>
</body>
</html>