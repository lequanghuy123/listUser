/**
 * Copyright(C) 2020 Luvina Software Company
 * MstGroupLogicImpl.java,Jul 16, 2020, HuyLQ
 * 	
 */
package manageuser.logics.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.MstGroupDao;
import manageuser.dao.impl.MstGroupDaoImpl;
import manageuser.logics.MstGroupLogic;

/**
 * @author HuyLQ
 *  
 */
public class MstGroupLogicImpl implements MstGroupLogic {
	/**
	 * Phương thức lấy ra list group 
	 * @return list Group 
	 */
	@Override
	public List<String> getAllMstGroup() {
		List<String> listGroup = new ArrayList<String>();
		MstGroupDao mstGroupDao = new MstGroupDaoImpl();
		try {
			listGroup = mstGroupDao.getAllMstGroup();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getClass() + ":" + e.getMessage());
			e.printStackTrace();
		}
		return listGroup;
	}

}
