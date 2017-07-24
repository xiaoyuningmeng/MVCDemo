package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.pojo.Product;
import com.company.service.factory.ServiceFactory;


@WebServlet("/ProductFindByNameServlet")
public class ProductFindByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-取值  
		String pname = request.getParameter("pname");
		//2-处理
		List<Product> productList = ServiceFactory.getProductInstance().findByName(pname);
		//3-反馈  
		if(productList != null && productList.size() > 0){
			request.setAttribute("productListFromServer", productList);
			request.getRequestDispatcher("/product_findAll.jsp").forward(request, response);
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", "no products!");
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
