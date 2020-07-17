/**
 * Copyright(C) 2020 Luvina Software Company
 * MstGroupDao,15-07-2020, HuyLQ
 * 	
 */
package manageuser.dao;

import java.sql.SQLException;
import java.util.List;

public interface MstGroupDao {
	public abstract List<String> getAllMstGroup() throws SQLException, ClassNotFoundException;
}
