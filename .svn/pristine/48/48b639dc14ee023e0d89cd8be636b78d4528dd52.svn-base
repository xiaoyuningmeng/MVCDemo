package com.company.mvc.service.test;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.ILoginService;

public class ILoginServiceTest {

	private ILoginService loginService;
	@Before
	public void setUp() throws Exception {
		loginService = ServiceFactory.getLoginInstance();
	}

	@Test
	public void testRegistry() {
		Login login = new Login("root","pwdroot");
		Detail detail = new Detail("ROOTT",11111);
		System.out.println(loginService.registry(login, detail));
	}

	@Test
	public void testLogin() {
		System.out.println(loginService.login(new Login("scott","tiger")));
		System.out.println(loginService.login(new Login("abc","tiger")));
	}

}
