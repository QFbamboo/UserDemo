package cn.bamboo.user.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bamboo.user.domain.User;
import cn.bamboo.user.service.UserException;
import cn.bamboo.user.service.UserService;
import cn.itcast.commons.CommonUtils;

public class RegistServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");// 请求编码POST
		response.setContentType("text/html;charset=utf-8");// 响应编码

		// 依赖UserService
		UserService userService = new UserService();

		/**
		 * 1,封装表单数据（封装到User对象中）
		 */
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		
		/**
		 * 新添加任务：
		 * 	检验验证码
		 * 		1.用户填写的验证码已经封装到User中
		 * 		2.从session获取真正的验证码
		 * 		3.比较两者，如果不同，保存错误信息、保存表单数据、转发到regist.jsp
		 * 		4.如果相同，什么都不做，向下执行
		 */
		String sessionVerifyCode=(String) request.getSession().getAttribute("session_vcode");
		if(!sessionVerifyCode.equalsIgnoreCase(form.getVerifyCode())){
			request.setAttribute("msg", "验证码错误！");
			request.setAttribute("user", form);
			request.getRequestDispatcher("/user/regist.jsp").forward(request,response);
			return;
		}
		/**
		 * 2,调用userSeervice的regist()方法，传递form过去
		 * 3，得到异常：获取异常信息，保存到request域中，转发到regist.jsp中显示 4，没有异常 ：注册成功
		 */
		try {
			userService.regist(form);
			response.getWriter().print(
					"<h1>注册成功！</h1><a href='" + request.getContextPath()
							+ "/user/login.jsp" + "'>点击这里去登录</a>");
		} catch (UserException e) {
			// 获取异常信息，保存到request域中
			request.setAttribute("msg", e.getMessage());
			//保存表单数据，到request域中
			request.setAttribute("user", form);
			// 转发到regist.jsp
			request.getRequestDispatcher("/user/regist.jsp").forward(request,
					response);
		}
	}
}
