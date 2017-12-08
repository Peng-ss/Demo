<%@page import="com.utils.Json_Utile"%>
<%@page
	import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@page import="com.bean.JsonData"%>
<%@page import="com.bean.User"%>
<%@page import="com.bean.Hero"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MY HERO HOME</title>
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

</head>
<body>
	<%
		/*通过Servlet传递过来的参数名来获取数据
		  getAttribute（）方法返回的是一个Object对象
		  需要把它转换成我们需要的JsonDate对象
		*/
		JsonData jsonData = (JsonData) request.getAttribute("jsonData");
		/* ArrayList<Hero> heros = (ArrayList<Hero>) request.getAttribute("heros"); */
		if (jsonData != null && jsonData.getMessage() == "英雄已存在") {
	%>
	<script>
		window.alert("你购买的英雄已存在！")
	</script>
	<%
		}
		if (jsonData != null && jsonData.getMessage() == "余额不足") {
	%>
	<script>
		window.alert("余额不足，请疯狂充钱！！！")
	</script>
	<%
		}
		if (jsonData != null && jsonData.getMessage() == "购买英雄成功") {
	%><script>
		window.alert("你购买英雄成功，快上坑！！")
	</script>
	<%
		}
	%>

	<%
		//获取到JsonDate对象中数据集合中第一个元素，就是一个User对象
		User user = jsonData.getDatas().get(0);
	%>
	<center>
		<h1>用户信息</h1>
		<p>
			用户名：<%=user.getUserName()%></p>
		<p>
			用户ID：<%=user.getId()%></p>
		<p>
			用户等级：<%=user.getLevel()%></p>
		<p>
			用户余额：<%=user.getBalance()%></p>
		&nbsp;&nbsp;
		<%
			if (jsonData.getMessage() == "充值成功！") {
				out.println("充值成功");
			} else if (jsonData.getMessage() == "充值失败！") {
				out.println("充值失败");
			}
		%>
		<form action="/recharge">
			<input type="hidden" name="username" value="<%=user.getUserName()%>"
				name="type" /> <input type="hidden" name="password"
				value="<%=user.getPassWord()%>" name="type" /> <input type="text"
				onkeyup="value=value.replace(/[^\d]/g,'') "
				style="background-color: transparent;" maxlength="4" name="balance" />
			<input type="submit" style="background-color: transparent;"
				value="充值" />
		</form>
		<h1 align="center">购买英雄</h1>
		<form method="get" action="/buyHero" style="width: 50%">
			<input type="hidden" name="user_id" value="<%=user.getId()%>" /> <input
				id="nn" type="hidden" name="username"
				value="<%=user.getUserName()%>" /> <input id="nn" type="hidden"
				name="password" value="<%=user.getPassWord()%>" /> <input
				type="hidden" value="<%=jsonData.getDatas()%>" name="user">
			<fieldset>
				<legend style="color: #000">请选择英雄</legend>
				<c:forEach items="${buyHeros}" var="buyHeros" varStatus="status">
					<img alt="无图片" src="${buyHeros.imgURL}" >
					<input type="radio" value="${status.index+1}" name="t_hero.id" />
				</c:forEach>
			</fieldset>
			<center>
				<br> <input type="submit" class="btn" value="确认"
					style="width: 100px" /> <br>
			</center>
		</form>
		<table style="width: 40%;">
			<font size="6px" color="#000">拥有的英雄</font>
			<!-- EL表达式的格式：${代码} -->
			<!-- 通过标签库，使用foreach循环，item是数据员，var是一次循环的变量（数据）别名 -->
			<c:forEach items="${heros}" var="hero">
				<tr>
					<th rowspan="6" style="width: 30%"><img alt="图片显示失败"
						style="width: 80%; height: 80%" src=${hero.imgURL}
						></th>
					<td style="width: 20%; color: #000">英雄名:</td>
					<td style="width: 20%; color: #000">${hero.heroName}</td>
				</tr>
				<tr>
					<td style="width: 20%; color: #000">英雄称号:</td>
					<td style="width: 20%; color: #000">${hero.heroTitle}</td>
				</tr>
				<tr>
					<td style="width: 20%; color: #000">英雄台词:</td>
					<td style="width: 20%; color: #000">${hero.heroLines}</td>
				</tr>
				<tr>
					<td style="width: 20%; color: #000">英雄类型:</td>
					<td style="width: 20%; color: #000">${hero.typeName}</td>
				</tr>
				<tr>
					<td style="width: 20%; color: #000">英雄国家:</td>
					<td style="width: 20%; color: #000">${hero.heroContry}</td>
				</tr>
				<tr>
					<td style="width: 20%; color: #000">英雄售价:</td>
					<td style="width: 20%; color: #000">${hero.heroPrice}</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>