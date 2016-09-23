package com.cike.session;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 购物车后台
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取参数
		String id = request.getParameter("id");
		//购物车存入商品名称和数量
		String[] names = {"手电筒","冰箱","手机","洗衣机"};
		int idx = Integer.parseInt(id);
		//商品名称
		String name = names[idx-1];
		//获取session
		HttpSession session = request.getSession();
		//从session获取购物车
		Map<String,Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
		//通过cart判断是否第一次购物
		if (cart==null) {
			//新建购物车，加入session
			cart = new HashMap<String,Integer>();
			cart.put(name, 1);
		}else{
			//如果不是第一次判断是否存在该商品
			if (cart.containsKey(name)) {
				//存在，取出，数量加1
				Integer count = cart.get(name);
				count++;
				cart.put(name, count);
			}else {
				//不存在
				cart.put(name, 1);
			}
		}
		//存入购物车
		session.setAttribute("cart", cart);
		//继续购物或者结算
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("<h3><a href='/ServletDemo/session/cartList.jsp'>继续购物</a>|<a href='/ServletDemo/session/pay.jsp'>结算</a></h3>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
