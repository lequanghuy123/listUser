package manageuser.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.TblUserDao;
import manageuser.entities.TblUserEntities;
import manageuser.entities.UserInfor;
import manageuser.utils.Common;
import manageuser.utils.Constant;

public class TblUserDaoImpl extends BaseDaoImpl implements TblUserDao {
	/**
	 * 
	 * Phương thức : Tạo connection tới DB trả về connection
	 */
	@Override
	public Connection getConnection() throws SQLException, ClassNotFoundException {

		try {
			Class.forName(Constant.CL_DRIVER);
			connection = DriverManager.getConnection(Constant.URL, Constant.USER_DB, Constant.PASSWORD_DB);
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		}
		return connection;
	}

	/**
	 * 
	 * Phương thức đóng kết nối Truyền vào kết nối cần đóng
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

	/**
	 * 
	 * 
	 */
	public TblUserEntities getUserByLoginName(String loginName) throws SQLException, ClassNotFoundException {
		TblUserEntities tblUser = null;
		try {
			// tạo connection
			connection = getConnection();
			// tạo câu query
			StringBuilder query = new StringBuilder("select login_name,pass,salt,rule from " + Constant.TBL_USER);
			query.append(" where " + Constant.TBL_USER + ".login_name = ? ");
			PreparedStatement statement = connection.prepareStatement(query.toString());
			statement.setString(1, loginName);
			// Thực hiện câu query
			ResultSet result = statement.executeQuery();
			// nếu tồn tại tập kết quả
			while (result.next()) {
				int i = 1;
				// tạo đối tượng tbl_user
				tblUser = new TblUserEntities("anh duc", "anh hung");
				// set loginName, passWord,salt,rule cho đối tượng
				tblUser.setLoginName(result.getString(i++));
				tblUser.setPassword(result.getString(i++));
				tblUser.setSalt(result.getString(i++));
				tblUser.setRule(result.getInt(i++));
			}
		} catch (SQLException | ClassNotFoundException e) {
			throw e;
		} finally {
			// đóng connection
			closeConnection(connection);
		}
		return tblUser;

	}
	/**
	 * Phương thức getListUser : lấy ra danh sách user
	 * @param offset : bước nhảy 
	 * @param limit : số user / 1 trang 
	 * @param groupID : id nhóm 
	 * @param fullName : tên đầy đủ
	 * @param sortype: thứ tự ưu tiên sắp xếp 
	 * @param sortByFullName : sắp xếp theo tên 
	 * @param sortByCodeLevel : sắp xếp theo trình độ tiếng nhật 
	 * @param sortByDate : loại sắp xếp theo ngày kết thúc
	 * @return listInFor : danh sách User
	 */

	@Override
	public List<UserInfor> getListUser(int offset, int limit, int groupId, String fullName, String sortType,
			String sortByFullName, String sortByCodeLevel, String sortByDate)
			throws SQLException, ClassNotFoundException {
		List<UserInfor> listUserInfors = new ArrayList<UserInfor>();
		Common common = new Common();
		try {
			// tạo connection
			connection = getConnection();
			// tạo câu query
			StringBuilder query = new StringBuilder(
					"select t.user_id,t.full_name,t.birthday,g.group_name,t.email,t.tel,j.name_level,tj.end_date,tj.total");
			query.append(" from " + Constant.TBL_USER + " t");
			query.append(" inner join " + Constant.MST_GROUP + " g" + " on g.group_id=t.group_id");
			query.append(" left join " + Constant.TBL_DETAIL_USER_JAPAN + " tj on tj.user_id=t.user_id");
			query.append(" left join " + Constant.MST_JAPAN +" j on  j.code_level=tj.code_level");
//			if (!common.isEmpty(fullName)) {
//				query.append(" where t.full_name like %?% ");
//				statement.setString(1, fullName);
//				if (groupId != 0) {
//					query.append(" and t.group_id = ? ");
//					statement.setInt(2, groupId);
//				}
//			} else {
//				if (groupId != 0) {
//					query.append(" where t.group_id = ? ");
//					statement.setInt(1, groupId);
//				}
//			}
			query.append(" order by t.full_name " + sortByFullName + " ,j.name_level " + sortByCodeLevel
					+ ",tj.end_date " + sortByDate);
			PreparedStatement statement = connection.prepareStatement(query.toString());
			ResultSet result = statement.executeQuery();
			// nếu tồn tại tập kết quả
			while (result.next()) {
				int i = 1;
				UserInfor userInfor = new UserInfor();
				userInfor.setUserId(result.getInt(i++));
				userInfor.setFullName(result.getString(i++));
				userInfor.setBirthDay(result.getDate(i++));
				userInfor.setGroupName(result.getString(i++));
				userInfor.setEmail(result.getString(i++));
				userInfor.setTel(result.getString(i++));
				userInfor.setNameLevel(result.getString(i++));
				userInfor.setEndDate(result.getDate(i++));
				userInfor.setTotal(result.getInt(i++));
				listUserInfors.add(userInfor);
			}
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("TblUserDaoImpl" + " : " + e.getMessage());
			throw e;
		} finally {
			// đóng connection
			closeConnection(connection);
		}
		return listUserInfors;
	}
}

