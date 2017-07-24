package com.company.mvc.service.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.company.dao.pojo.Product;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IProductService;

public class ServiceProductImplTest {
	IProductService productService;

	@Before
	public void setUp() throws Exception {
		productService = ServiceFactory.getProductInstance();
	}

	@Test
	public void testSave() {
		Product p = new Product("FFF","fff",123.45);
		p.setPid(11);
		String msg = productService.save(p);
		System.out.println("success".equals(msg)?"save success£¡":"save error!");
	}

	@Test
	public void testUpdate() {
		Product p = new Product();
		p.setPid(6);
		p.setPname("FFFFF");
		p.setEan("ffff");
		p.setPrice(150.00);
		System.out.println(productService.update(p));
	}

	@Test
	public void testDelete() {
		Product p = new Product();
		p.setPid(3);
		System.out.println(productService.delete(p));
	}

	@Test
	public void testFindAll() {
		List<Product> productList = productService.findAll();
		for(Product p:productList){
			System.out.println(p);
		}
	}

	@Test
	public void testFindById() {
		System.out.println(productService.findById(2));
	}

	@Test
	public void testFindByName() {
		List<Product> productList = productService.findByName("F");
		for(Product p:productList){
			System.out.println(p);
		}
	}

	@Test
	public void testFindByPage() {
		List<Product> productList = productService.findByPage(2, 4);
		for(Product p:productList){
			System.out.println(p);
		}
	}

}
