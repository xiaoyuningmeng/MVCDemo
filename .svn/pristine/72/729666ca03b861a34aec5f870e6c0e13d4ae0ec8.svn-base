package com.company.dao.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class SessionFactory {
	private DataSource ds;//由于SessionFactory是单例的，所以ds也是唯一的
	//使用单例模式的懒汉形式实现SessionFactory的单例化
	private SessionFactory() {
		ds = new ComboPooledDataSource();
	}
	private static SessionFactory sessionFactory;
	public static SessionFactory getInstance(){
		if(sessionFactory == null){
			sessionFactory = new SessionFactory();
		}
		return sessionFactory;
	}
	
	public Connection getSession() throws Exception {
		Connection con =  ds.getConnection();
		System.out.println("连接池："+ds);
		return con;
	}

	public void close(ResultSet rs, Statement ps, Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
