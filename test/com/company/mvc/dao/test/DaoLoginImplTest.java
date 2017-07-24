package com.company.mvc.dao.test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.company.dao.idao.ILoginDao;
import com.company.dao.impl.DaoLoginImpl;
import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;

public class DaoLoginImplTest {
	private ILoginDao loginDao;
	@Before
	public void setUp() throws Exception {
		loginDao = new DaoLoginImpl();
	}

	@Test
	public void testRegistry() throws Exception {
		Login login = new Login("scott","tiger");//Oracle数据库的学习环境登录用户  scott  tiger
		Detail detail = new Detail("SCOTT-TIGER",9000.80);
		loginDao.registry(login, detail);
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

}
