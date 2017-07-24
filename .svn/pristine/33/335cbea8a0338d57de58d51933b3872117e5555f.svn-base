package com.company.service.impl;

import java.util.List;

import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.ILoginDao;
import com.company.dao.pojo.Detail;
import com.company.dao.pojo.Login;
import com.company.service.iservice.ILoginService;

public class ServiceLoginImpl implements ILoginService {

	private ILoginDao loginDao;

	public ServiceLoginImpl() {
		super();
		this.loginDao = DaoFactory.getLoginInstance();
	}

	@Override
	public String registry(Login login, Detail detail) {
		String msg = "error";
		try {
			loginDao.registry(login, detail);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String login(Login login) {
		String msg = "error";
		try {
			Login result = loginDao.login(login);
			if (result != null) {
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String save(Login t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Login t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Login t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Login> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login findById(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

}
