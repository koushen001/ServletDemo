<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>结算页面</h3>
	<%
		//从session获取购物车
		Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
		if(cart!=null){
			for(String key:cart.keySet()){
	%>
	<h3>亲，您购买的商品是<%=key %>，数量是<%=cart.get(key) %></h3>
	<%
			}
		}else{
	%>
	<h3>亲，您还没有购物。<a href="/ServletDemo/session/cartList.jsp">去购物</a></h3>>
	<%
		}
	%>
</body>
</html>