package cn.bamboo.user.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bamboo.user.service.UserService;

public class LoginServlet extends HttpServlet {

	/**
	 * UserServlet层
	 * 
	 * */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");// 请求编码POST
		response.setContentType("text/html;charset=utf-8");// 响应编码

		// 依赖UserService
		UserService userService = new UserService();

	}

}
