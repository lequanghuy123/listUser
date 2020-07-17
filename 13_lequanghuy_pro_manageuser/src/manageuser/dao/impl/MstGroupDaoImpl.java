/**
 * Copyright(C) 2020 Luvina Software Company
 * MstGroupDaoImpl.java,Jul 16, 2020, HuyLQ
 * 	
 */
package manageuser.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.MstGroupDao;
import manageuser.utils.Constant;

public class MstGroupDaoImpl extends BaseDaoImpl implements MstGroupDao {
/*
 * Phương thức : lấy ra tập gái trị tên nhsom 
 *@return List<String>: ten group
 *@throws SQLException
 *@throws ClassNotFoundException
 *
 */
	@Override
	public List<String> getAllMstGroup() throws SQLException,ClassNotFoundException {
		List<String> listGroup = new ArrayList<String>();
		try {
			// tạo connection 
			connection = getConnection(); 
		// tạo câu query
			StringBuilder query = new StringBuilder("select group_name from " + Constant.MST_GROUP);
			query.append(" order by "+Constant.MST_GROUP+".group_id asc");
			PreparedStatement statement = connection.prepareStatement(query.toString());
			//Thực hiện câu query 
			ResultSet result = statement.executeQuery();
			// nếu tồn tại tập kết quả
			while (result.next()) {
				listGroup.add(result.getString("group_name"));
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e.getClass()+":"+e.getMessage());
			throw e ;
		} finally {
			// đóng connection 
			closeConnection(connection);
		}
		return listGroup;
	}

}
