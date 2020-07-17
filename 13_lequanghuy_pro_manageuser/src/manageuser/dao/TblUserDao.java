/**
 * Copyright(C) 2020 Luvina Software Company
 * TblUserDao,15-07-2020, HuyLQ
 * 	
 */
package manageuser.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import manageuser.entities.UserInfor;

public interface TblUserDao {
	public abstract Connection getConnection() throws SQLException, ClassNotFoundException;
	public abstract void closeConnection(Connection connection) throws SQLException;
	public abstract List<UserInfor> getListUser(int offset,int limit,int groupid,String fullName,String sortType,String sortByFullName,String sortByCodeLevel,String sortByDate) throws SQLException, ClassNotFoundException;
}
