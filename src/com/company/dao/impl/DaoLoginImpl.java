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
		// 1-��ȡ����
		Connection con = SessionFactory.getInstance().getSession();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		// 2-�ر����ӵ��Զ��ύ����(��������)
		con.setAutoCommit(false);
		try {
			// 3-ִ��ע�Ṧ�ܣ���һ��һ��ϵ�����ű�t_login��t_detail�ֱ𱣴����ݣ�
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
			// 4-���ִ��ȫ���ɹ������ύcommit
			con.commit();
		} catch (Exception e) {
			// 5-���ִ�й����г����κ��쳣���ع�rollback
			con.rollback();
			throw e;// ��ѭһ��ԭ�����е��쳣������service����dao�㸺�����쳣
		} finally {
			// 6-�ر����ݿ�������Դ
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

	// ����Ϊversion1.0�ɲü�ģ��

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
