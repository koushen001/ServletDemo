package com.cike.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cike.utils.MyCookieUtil;

/**
 * 浏览记录后台
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求参数，目的：存入到cookie中
		String id = request.getParameter("id");
		// 先获取所有cookie，查找指定cookie
		Cookie[] cookies = request.getCookies();
		// 查找指定名称的cookie
		Cookie cookie = MyCookieUtil.getCookieByName(cookies, "product");
		if (cookie == null) {
			// 第一次访问，创建cookie，回写
			Cookie c = new Cookie("product", id);
			//设置有效路径
			c.setPath("/");
			// 回写
			response.addCookie(c);
		} else {
			// 如果不是第一次访问
			// 获取cookie的value
			String value = cookie.getValue();
			// 判断商品id是否在cookie中
			String flag = "#";
			String[] values = value.split(flag);
			if (!checkId(values, id)) {
				// 不包含
				cookie.setValue(value + flag + id);
				//设置有效时间七天
				cookie.setMaxAge(7*24*60*60);
				//设置有效路径
				cookie.setPath("/");
				//回写
				response.addCookie(cookie);
			}
		}
		//重定向到商品页面
		response.sendRedirect("/ServletDemo/cookie/productList.jsp");
	}

	/**
	 * 判断当前id是否在values数组中
	 * 
	 * @param values
	 * @param id
	 * @return
	 */
	private boolean checkId(String[] values, String id) {
		for (String string : values) {
			if (string.equals(id)) {
				return true;
			}
		}
		return false;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
