package com.cike.response;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

/**
 * 验证码
 */
@WebServlet(name = "checkcode", urlPatterns = { "/checkcode" })
public class CheckcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 在内存中生成图片
		int width = 120;
		int height = 30;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		// 获取画笔对象
		Graphics g = image.getGraphics();
		// 设置灰色
		g.setColor(Color.GRAY);
		// 画填充的矩形
		g.fillRect(0, 0, width, height);
		// 设置颜色
		g.setColor(Color.blue);
		// 画边框
		g.drawRect(0, 0, width - 1, height - 1);
		// 准备数据，随机获取4个字符
		String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		// 设置颜色
		g.setColor(Color.YELLOW);
		// 设置字体
		g.setFont(new Font("隶书", Font.BOLD, 20));
		Random random = new Random();
		int x = 20;
		int y = 20;
		for (int i = 0; i < 4; i++) {
			// 获取下标
			int index = random.nextInt(words.length());
			// 返回指定下标位置的字符，随机获取下标
			char ch = words.charAt(index);
			// 写字符串
			g.drawString("" + ch, x, y);
			x += 20;
		}
		// 设置颜色
		g.setColor(Color.red);
		// 画干扰线
		int x1, x2, y1, y2;
		for (int i = 0; i < 4; i++) {
			x1 = random.nextInt(width);
			y1 = random.nextInt(height);
			x2 = random.nextInt(width);
			y2 = random.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
		// 输出到客户端
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
