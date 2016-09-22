package com.cike.cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cike.utils.MyCookieUtil;

/**
 * 记录上次的访问时间
 */
@WebServlet("/LastServlet")
public class LastServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置字符中文乱码问题
		response.setContentType("text/html;charset=UTF-8");
		//获取所有的cookie
		Cookie[] cookies = request.getCookies();
		//通过指定cookie名称来查找cookie
		Cookie cookie = MyCookieUtil.getCookieByName(cookies, "last");
		//判断，如果cookie===null，说明第一次访问
		if (cookie==null) {
			//输出欢迎，记录当前时间，回写到浏览器
			response.getWriter().write("<h3>亲，欢迎再来额！！！</h3>");
		}else {
			//获取到cookie的值，输出浏览器，记录当前时间，回写到浏览器
			String value = cookie.getValue();
			//输出到浏览器
			response.getWriter().write("<h3>亲，您又来了，上次的时间是："+value+"</h3>");
		}
		//记录当前时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sDate = sdf.format(date);
		//回写到浏览器
		//使用cookie回写
		Cookie c = new Cookie("last", sDate);
		//回写
		response.addCookie(c);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
