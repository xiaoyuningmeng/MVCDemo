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

@WebServlet("/ProductFindAllServlet")
public class ProductFindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1-取值  从V层（html或jsp）取  （由于是findAll操作，无需传参，所以此步骤略）
		
		//2-处理  调用M层功能（Service---接口IProductService 工厂ServiceFactory）
		List<Product> productList = ServiceFactory.getProductInstance().findAll();
		//3-反馈  
			//3.1-直接输出，实现json数据的ajax请求   
			// PrintWriter out = response.getWriter();
			// out.println(productList.toString());
		//3.2--转发（传递值）   3.3--重定向（相当于重新访问一个新的url）
		if(productList != null && productList.size() > 0){
			//4-将数据存入request中，并转发跳转到product_findAll.jsp页面
			request.setAttribute("productListFromServer", productList);
			request.getRequestDispatcher("/product_findAll.jsp").forward(request, response);
		}else{
			//5-跳转到错误页，传递错误信息：没有任何商品
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", "no products!");
			response.sendRedirect(request.getContextPath()+"/error.jsp");
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
