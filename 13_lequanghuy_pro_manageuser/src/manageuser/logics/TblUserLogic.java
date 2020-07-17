package manageuser.logics;

import java.sql.SQLException;
import java.util.List;

import manageuser.entities.UserInfor;

public interface TblUserLogic {
	public abstract boolean checkExistLogin(String loginName, String passInput) throws SQLException, ClassNotFoundException;
	public abstract List<UserInfor> getListUser(int offset,int limit,int groupId,String fullName,String sortType,String sortByFullName,String sortByCodeLevel,String sortByDate) throws ClassNotFoundException, SQLException;
}
