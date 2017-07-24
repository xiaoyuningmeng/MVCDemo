package com.company.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.pojo.Login;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.ILoginService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-取值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Login login = new Login(username,password);
		
		//2-处理
		ILoginService loginService = ServiceFactory.getLoginInstance();
		String msg = loginService.login(login);
		//3-反馈
		if("success".equals(msg)){
			//4-如果登录成功，一般会将公共信息放入session中，所有页面共享使用，例如欢迎信息
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			//5-假设，进入到产品列表页面
			response.sendRedirect(request.getContextPath()+"/ProductFindAllServlet");
		}else{
			//5-跳转到错误页
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", "login error!");
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
