package com.company.dao.factory;

import com.company.dao.idao.ILoginDao;
import com.company.dao.idao.IProductDao;
import com.company.dao.impl.DaoLoginImpl;
import com.company.dao.impl.DaoProductImpl;

public class DaoFactory {
	public static IProductDao getProductInstance() {
		return new DaoProductImpl();
	}
	public static ILoginDao getLoginInstance() {
		return new DaoLoginImpl();
	}
}
