package com.cike.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 清除cookie
 */
@WebServlet("/remove")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建cookie的名称为product
		Cookie cookie = new Cookie("product", "");
		//设置有效时间
		cookie.setMaxAge(0);
		//设置有效路径
		cookie.setPath("/");
		//回写
		response.addCookie(cookie);
		//重定向到商品页面
		response.sendRedirect("/ServletDemo/cookie/productList.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
