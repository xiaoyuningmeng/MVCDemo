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

@WebServlet("/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-取值  
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		String ean = request.getParameter("ean");
		double price = Double.parseDouble(request.getParameter("price"));
		//2-处理
		Product p = new Product(pname,ean,price);
		p.setPid(pid);
		String msg = ServiceFactory.getProductInstance().update(p);
		//3-反馈  
		if("success".equals(msg)){
			response.sendRedirect(request.getContextPath()+"/ProductFindAllServlet");			
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", "update error!");
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
