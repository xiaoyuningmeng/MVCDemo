package com.company.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.ILoginService;

@WebServlet("/RegistryServlet")
public class RegistryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		double balance = Double.parseDouble(request.getParameter("balance"));
		Login login = new Login(username,password);
		Detail detail = new Detail(realname,balance);
		//2
		ILoginService loginService = ServiceFactory.getLoginInstance();
		String msg = loginService.registry(login, detail);
		//3
		if("success".equals(msg)){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			//5-跳转到错误页，传递错误信息：没有任何商品
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", "registry error!");
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
