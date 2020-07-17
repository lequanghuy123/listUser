/**
 * Copyright(C) 2020 Luvina Software Company
 * TblUserLogicImpl,15-07-2020, HuyLQ
 * 	
 */
package manageuser.logics.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manageuser.dao.impl.TblUserDaoImpl;
import manageuser.entities.TblUserEntities;
import manageuser.entities.UserInfor;
import manageuser.logics.TblUserLogic;
import manageuser.utils.Common;

public class TblUserLogicImpl implements TblUserLogic {
	TblUserDaoImpl tblUserDaoImpl = new TblUserDaoImpl();

	/**
	 * Phương thức check tồn tại loginName 2 tham số (LoginName và pass) Thực hiện
	 * @param login Name
	 * @param passInput
	 * @return true khi tồn tại User và đúng pass, false khi ngược lại 
	 */
	@Override
	public boolean checkExistLogin(String loginName, String passInput) throws SQLException, ClassNotFoundException {
		TblUserEntities user;
		try {
			user = tblUserDaoImpl.getUserByLoginName(loginName);
			if (user == null) {
				return false;

			} else {
				Common common = new Common();
				String encryptedPass = common.encriptPassWord(user.getSalt(), passInput);
				if (common.compareString(encryptedPass, user.getPassword())) {
					return true;
				}
//			if(passInput.equals(user.getPassword())) {
//				return true;
//			}
			}
		} catch (SQLException e) {
			System.out.println(e.getClass() + " : " + e.getMessage());
			throw e;
		}
		return false;
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
			throws ClassNotFoundException, SQLException {
		List<UserInfor> listUserInfors = new ArrayList<UserInfor>();
		try {
			listUserInfors = tblUserDaoImpl.getListUser(offset, limit, groupId, fullName, sortType, sortByFullName,
					sortByCodeLevel, sortByDate);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(" TblUserLogicImpl " + " : " + e.getMessage());
			throw e;
		}
		return listUserInfors;
	}
}

