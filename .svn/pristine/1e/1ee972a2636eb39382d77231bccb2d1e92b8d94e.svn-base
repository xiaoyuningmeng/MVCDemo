package com.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.company.dao.idao.ILoginDao;
import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;
import com.company.dao.util.SessionFactory;

public class DaoLoginImpl implements ILoginDao {

	@Override
	public void registry(Login login, Detail detail) throws Exception {
		// 1-获取连接
		Connection con = SessionFactory.getInstance().getSession();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		// 2-关闭连接的自动提交功能(启动事务)
		con.setAutoCommit(false);
		try {
			// 3-执行注册功能（向一对一关系的两张表t_login，t_detail分别保存数据）
			String sql1 = "insert into t_login(username,password) values(?,?)";
			String sql2 = "insert into t_detail(realname,balance) values(?,?)";
			ps1 = con.prepareStatement(sql1);
			ps1.setString(1, login.getUsername());
			ps1.setString(2, login.getPassword());
			ps2 = con.prepareStatement(sql2);
			ps2.setString(1, detail.getRealname());
			ps2.setDouble(2, detail.getBalance());
			ps1.executeUpdate();
			ps2.executeUpdate();
			// 4-如果执行全部成功，则提交commit
			con.commit();
		} catch (Exception e) {
			// 5-如果执行过程中出现任何异常，回滚rollback
			con.rollback();
			throw e;// 遵循一个原则，所有的异常都交给service处理，dao层负责抛异常
		} finally {
			// 6-关闭数据库连接资源
			SessionFactory.getInstance().close(null, ps2, null);
			SessionFactory.getInstance().close(null, ps1, con);
		}
	}

	@Override
	public Login login(Login login) throws Exception {
		Connection con = SessionFactory.getInstance().getSession();
		String sql = "select id,username,password from t_login where username=? and password=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, login.getUsername());
		ps.setString(2, login.getPassword());
		ResultSet rs = ps.executeQuery();
		Login result = null;
		if (rs.next()) {
			result = new Login(rs.getString(2), rs.getString(3));
			result.setId(rs.getInt(1));
		}
		return result;
	}

	// 以下为version1.0可裁剪模块

	@Override
	public void save(Login t) throws Exception {

	}

	@Override
	public void update(Login t) throws Exception {

	}

	@Override
	public void delete(Login t) throws Exception {

	}

	@Override
	public List<Login> findAll() throws Exception {
		return null;
	}

	@Override
	public Login findById(Integer k) throws Exception {
		return null;
	}
}
