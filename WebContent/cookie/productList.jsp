<%@page import="com.cike.utils.MyCookieUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/ServletDemo/product?id=1">手机1</a>
	<a href="/ServletDemo/product?id=2">手机2</a>
	<a href="/ServletDemo/product?id=3">手机3</a>
	<a href="/ServletDemo/product?id=4">手机4</a>
	<a href="/ServletDemo/product?id=5">手机5</a>
	<a href="/ServletDemo/product?id=6">手机6</a>
	<hr>
	<h3>浏览记录</h3>
	<h3><a href="/ServletDemo/remove">清除记录</a></h3>
	<%
		//获取cookie中的value
		Cookie[] cookies = request.getCookies();
		//查找指定名次的cookie
		Cookie cookie = MyCookieUtil.getCookieByName(cookies, "product");
		//如果cookie不为空，拿到值遍历
		if (cookie != null) {
			String value = cookie.getValue();
			//分隔
			String[] ids = value.split("#");
			//循环遍历，获取id
			for (String id : ids) {
	%>
	<a href="/ServletDemo/product?id=6">手机<%=id%></a>
	<%
		}
		}
	%>

</body>
</html>