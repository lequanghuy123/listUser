/**
 * Copyright(C) 2020 Luvina Software Company
 * BaseDao.java,Jul 16, 2020, HuyLQ
 * 	
 */
package manageuser.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author HuyLQ
 *
 */
public interface BaseDao {
	public abstract Connection getConnection() throws SQLException, ClassNotFoundException;
	public abstract void closeConnection(Connection connection) throws SQLException;
}
