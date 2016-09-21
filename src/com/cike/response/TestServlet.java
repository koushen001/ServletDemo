package com.cike.response;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(name = "test", urlPatterns = { "/test" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//在内存中生成图片
		BufferedImage image = new BufferedImage(300, 500, BufferedImage.TYPE_INT_BGR);
		//获取画笔对象
		Graphics g = image.getGraphics();
		//设置颜色
		g.setColor(Color.RED);
		//画一个矩形
		g.drawRect(100, 100, 150, 100);
		//定义字符串
		g.setColor(Color.YELLOW);
		String str = "abc";
		g.drawString(str,80,80);
		//把内存中的图片输出到浏览器端
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
