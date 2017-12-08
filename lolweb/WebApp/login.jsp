<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="com.bean.JsonData"%>
   <%@page import="com.bean.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到    My Hero</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

</head>
<body >
	<%
		JsonData jsonData = (JsonData) request.getAttribute("jsonData");
		if (jsonData != null && jsonData.getResult()==false) {
	%>
	<script>
		window.alert("用户不存在或者密码不正确！！！！")
	</script>
	<%
		}
	%>
	<div id="Layer1"
		style="position: absolute; width: 100%; height: 100%; z-index: -1; background-position: center; background-repeat: no-repeat; background-attachment: fixed;">
		<img src="img/login.jpg" width="100%" height="100%" />
	</div>
<center>
<br>
<br>
<h1>召唤师登陆</h1>
<br>
<br>
<form action="/login" method="get">
		  <p >用户账号： <input type="text" name="username" placeholder="请输入账号" style="background-color:transparent;"/></p>
 		 <p >用户密码： <input  type="password" name="password" placeholder="请输入密码" style="background-color:transparent;"/></p>
 		 <br>
 		 <input type="submit" value="登录"  style="width:80px;height :30px;background-color:transparent;font-size:15px;color:#000;" />
 		 <a href="register.jsp" style="text-decoration:none;"><input type="button" value="注册"style="width:80px;height :30px;background-color:transparent;font-size:15px;color:#000;" /></a>
 </form>
</center>
</body>
<script>
		window.jQuery
				|| document
						.write('<script src="js/jquery-2.1.1.min.js"><\/script>')
	</script>
	<script>
		// JavaScript for label effects only
		$(window).load(function() {
			$(".col-3 input").val("");

			$(".input-effect input").focusout(function() {
				if ($(this).val() != "") {
					$(this).addClass("has-content");
				} else {
					$(this).removeClass("has-content");
				}
			})
		});
	</script>
</html>