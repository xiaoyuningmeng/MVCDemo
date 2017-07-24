package com.company.service.impl;

import java.util.List;

import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IProductDao;
import com.company.dao.pojo.Product;
import com.company.service.iservice.IProductService;

public class ServiceProductImpl implements IProductService {

	private IProductDao productDao;

	public ServiceProductImpl() {
		productDao = DaoFactory.getProductInstance();
	}

	@Override
	public String save(Product t) {
		// 1-生成返回值变量msg
		String msg = "error";
		// 2-调用dao层方法，service处理产生的异常
		try {
			// 3-执行save的前提：数据库中没有该条记录
			Product p = productDao.findById(t.getPid());
			if (p == null) {
				productDao.save(t);
				msg = "success";// Struts2框架中有类似要求
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String update(Product t) {
		String msg = "error";
		try {
			Product p = productDao.findById(t.getPid());
			if (p != null) {
				productDao.update(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String delete(Product t) {
		String msg = "error";
		try {
			Product p = productDao.findById(t.getPid());
			if (p != null) {
				productDao.delete(t);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Product> findAll() {
		List<Product> productList = null;
		try {
			productList = productDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public Product findById(Integer k) {
		Product product = null;
		try {
			product = productDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> findByName(String pname) {
		List<Product> productList = null;
		try {
			productList = productDao.findByName(pname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<Product> findByPage(int page, int size) {
		List<Product> productList = null;
		try {
			productList = productDao.findByPage(page, size);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

}
