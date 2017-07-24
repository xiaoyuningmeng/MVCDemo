package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.pojo.Product;
import com.company.service.factory.ServiceFactory;

@WebServlet("/ProductDeleteServlet")
public class ProductDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1-取值
		int pid = Integer.parseInt(request.getParameter("pid"));
		// 2-处理
		Product p = new Product();
		p.setPid(pid);
		String msg = ServiceFactory.getProductInstance().delete(p);
		// 3-反馈
		if ("success".equals(msg)) {
			response.sendRedirect(request.getContextPath() + "/ProductFindAllServlet");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", "delete error!");
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
