package com.cike.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 乱码解决
 */
@WebServlet(name = "req", urlPatterns = { "/req" })
public class ReqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see 解决get请求乱码
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		System.out.println(username);
	}

	/**
	 * @see 解决POST请求乱码
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println(new String(username.getBytes("ISO-8859-1"), "UTF-8"));
	}

}
