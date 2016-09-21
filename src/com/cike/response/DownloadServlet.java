package com.cike.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取文件，读到流中
		//获取文件的绝对磁盘路径
		String path = getServletContext().getRealPath("/img/游戏美女.jpg");
		//截取文件名称
		String fileName = null;
		int index = path.lastIndexOf("\\");
		if (index!=-1) {
			fileName = path.substring(index+1);
		}
		String agent = request.getHeader("User-Agent");
		System.out.println(agent);
		//判断浏览器
		if (agent.contains("MSIE")) {
			fileName = URLEncoder.encode(fileName,"UTF-8");
		}
		//设置头信息
		response.setHeader("Content-Disposition","attachment;filename="+fileName);
		System.out.println(path);
		InputStream in = new FileInputStream(path);
		//通过response读到客户端
		OutputStream os = response.getOutputStream();
		//io的拷贝
		byte[] b = new byte[1024];
		int len = 0;
		while((len = in.read(b))!=-1){
			os.write(b,0,len);
		}
		in.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
