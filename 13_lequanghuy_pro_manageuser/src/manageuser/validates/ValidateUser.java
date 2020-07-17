package manageuser.validates;

import java.sql.SQLException;
import java.util.ArrayList;

import manageuser.logics.TblUserLogic;
import manageuser.logics.impl.TblUserLogicImpl;
import manageuser.utils.MessageErrorProperties;

/**
 * Class ValidateUser Dùng để validate dữ liệu nhập vào từ màn ADM001 
 * 
 */
public class ValidateUser {
	/**
	 * Phương thức validateLogin để kiểm tra loginName và passWord người dùng nhập
	 * vào
	 * @param : LoginName
	 * @param : PassInput
	 * @return List lỗi
	 */
	public ArrayList<String> validateLogin(String loginName, String passInput)
			throws SQLException, ClassNotFoundException {
		ArrayList<String> errorList = new ArrayList<String>();
		try {
			TblUserLogic tblUserLogicImpl = new TblUserLogicImpl();
			if ("".equals(loginName) || loginName.equals(null)) {
				errorList.add(MessageErrorProperties.getValueByKey("ERR001_LOGIN_NAME"));
			}
			if ("".equals(passInput) || passInput.equals(null)) {
				errorList.add(MessageErrorProperties.getValueByKey("ERR001_PASSWORD"));
			}
			if (errorList.isEmpty()) {
				if (!tblUserLogicImpl.checkExistLogin(loginName, passInput)) {
					errorList.add(MessageErrorProperties.getValueByKey("ERR016"));
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getClass()+":"+e.getMessage());
			throw e;
		}
		return errorList;
	}
}
