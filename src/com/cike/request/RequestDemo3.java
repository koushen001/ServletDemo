package com.cike.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向和转发
 * 重定向和转发的区别
 *  1.重定向是两次请求，两次响应；转发是一次请求，一次响应
 *  2.重定向地址栏发生了变化；转发地址栏没有变化
 *  3.重定向不能使用reques域传递数据；转发传递数据
 *  4.重定向可以定向其他系统；转发只能在系统内部
 */
@WebServlet(name = "request3", urlPatterns = { "/request3" })
public class RequestDemo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("name", "凤姐");
		// 完成重定向的工作（客户端绝对路径）
		// response.sendRedirect("/ServletDemo/request4");
		// 转发（服务器端绝对路径）
		request.getRequestDispatcher("/request4").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
