/**
 * Copyright(C) 2020 Luvina Software Company
 * BaseDaoImpl.java,Jul 16, 2020, HuyLQ
 * 	
 */
package manageuser.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import manageuser.dao.BaseDao;
import manageuser.utils.Constant;

/**
 * @author HuyLQ
 *
 */
public class BaseDaoImpl implements BaseDao{

	protected PreparedStatement statement;
	protected Connection connection = null;
/**
 * Phương thức : Tạo connection tới DB
 * @return connection 
 */
	@Override
	public Connection getConnection() throws SQLException, ClassNotFoundException{

		try {
			Class.forName(Constant.CL_DRIVER);
			connection = DriverManager.getConnection(Constant.URL, Constant.USER_DB, Constant.PASSWORD_DB);
		} catch (ClassNotFoundException | SQLException e) {
			throw e ;
		}
		return connection;
	}
/**
 *  Phương thức đóng kết nối 
 *  @param :connection
 */
	@Override
	public void closeConnection(Connection connection) throws SQLException {
		// TODO Auto-generated method stub
		try {
			if (!connection.isClosed() && connection.equals(null)) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

}
