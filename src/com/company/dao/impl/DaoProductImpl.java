package com.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.dao.idao.IProductDao;
import com.company.dao.pojo.Product;
import com.company.dao.util.SessionFactory;

public class DaoProductImpl implements IProductDao {

	@Override
	public void save(Product t) throws Exception {
		// 1-获得数据库连接 SessionFactory.getInstance()
		Connection con = SessionFactory.getInstance().getSession();
		// 2-编写SQL语句，执行插入数据的功能
		String sql = "insert into t_product(pname,ean,price) values(?,?,?)";
		// 3-封装SQL语句为JDBC对象---PreparedStatement
		PreparedStatement ps = con.prepareStatement(sql);
		// 4-完善SQL语句（给SQL语句赋予参数值）
		ps.setString(1, t.getPname());
		ps.setString(2, t.getEan());
		ps.setDouble(3, t.getPrice());
		// 5-执行SQL语句
		ps.executeUpdate();
		// 6-关闭所有资源 调用SessionFactory.getInstance()中的工具方法
		SessionFactory.getInstance().close(null, ps, con);
	}

	@Override
	public void update(Product t) throws Exception {
		Connection con = SessionFactory.getInstance().getSession();
		String sql = "update t_product set pname=?,ean=?,price=? where pid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, t.getPname());
		ps.setString(2, t.getEan());
		ps.setDouble(3, t.getPrice());
		ps.setInt(4, t.getPid());
		ps.executeUpdate();
		SessionFactory.getInstance().close(null, ps, con);

	}

	@Override
	public void delete(Product t) throws Exception {
		Connection con = SessionFactory.getInstance().getSession();
		String sql = "delete from t_product where pid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getPid());
		ps.executeUpdate();
		SessionFactory.getInstance().close(null, ps, con);
	}

	@Override
	public List<Product> findAll() throws Exception {
		// 1-获得连接
		Connection con = SessionFactory.getInstance().getSession();
		// 2-封装并执行SQL语句，获得结果集ResultSet
		String sql = "select pid,pname,ean,price from t_product";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		// 3-遍历ResultSet结果集，形成对象集合
		List<Product> productList = new ArrayList<Product>();
		while (rs.next()) {
			Product p = new Product(rs.getString(2), rs.getString(3), rs.getDouble(4));
			p.setPid(rs.getInt(1));
			productList.add(p);
		}
		// 4-关闭资源，返回对象集合
		return productList;
	}

	@Override
	public Product findById(Integer k) throws Exception {
		Connection con = SessionFactory.getInstance().getSession();
		// 声明精确查询的sql语句
		String sql = "select pid,pname,ean,price from t_product where pid=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, k);
		ResultSet rs = ps.executeQuery();
		Product p = null;
		if (rs.next()) {
			p = new Product(rs.getString(2), rs.getString(3), rs.getDouble(4));
			p.setPid(rs.getInt(1));
		}
		return p;
	}

	@Override
	public List<Product> findByName(String pname) throws Exception {
		Connection con = SessionFactory.getInstance().getSession();
		// 声明模糊查询的sql语句
		String sql = "select pid,pname,ean,price from t_product where pname like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + pname + "%");
		ResultSet rs = ps.executeQuery();
		List<Product> productList = new ArrayList<Product>();
		while (rs.next()) {
			Product p = new Product(rs.getString(2), rs.getString(3), rs.getDouble(4));
			p.setPid(rs.getInt(1));
			productList.add(p);
		}
		return productList;
	}

	@Override
	public List<Product> findByPage(int page, int size) throws Exception {
		// 1-获得连接
		Connection con = SessionFactory.getInstance().getSession();
		// 2-封装并执行SQL语句，获得结果集ResultSet
		String sql = "select pid,pname,ean,price from t_product limit ?,?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, (page-1)*size);
		ps.setInt(2, size);
		ResultSet rs = ps.executeQuery();
		// 3-遍历ResultSet结果集，形成对象集合
		List<Product> productList = new ArrayList<Product>();
		while (rs.next()) {
			Product p = new Product(rs.getString(2), rs.getString(3), rs.getDouble(4));
			p.setPid(rs.getInt(1));
			productList.add(p);
		}
		// 4-关闭资源，返回对象集合
		return productList;
	}
	
}
