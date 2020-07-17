/**
 * Copyright(C) 2020 Luvina Software Company
 * TblUserEntities,15-07-2020, HuyLQ
 * 	
 */
package manageuser.entities;
import java.sql.Date;
/**
 * Class TblUserEntities (javabean)
 * @author HuyLQ
 */
public class TblUserEntities {
	private int iD;
	private int groupId;
	private String password;
	private String loginName;
	private String fullname;
	private String fullnameKana;
	private String email;
	private String tel;
	private Date birthday;
	private int rule;
	private String salt;

	public int getiD() {
		return iD;
	}

	public TblUserEntities(int iD, int groupId, String password, String loginName, String fullname, String fullnameKana,
			String email, String tel, Date birthday, int rule, String salt) {
		this.iD = iD;
		this.groupId = groupId;
		this.password = password;
		this.loginName = loginName;
		this.fullname = fullname;
		this.fullnameKana = fullnameKana;
		this.email = email;
		this.tel = tel;
		this.birthday = birthday;
		this.rule = rule;
		this.salt = salt;
	}

	public TblUserEntities(String password, String loginName) {
		super();
		this.password = password;
		this.loginName = loginName;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFullnameKana() {
		return fullnameKana;
	}

	public void setFullnameKana(String fullnameKana) {
		this.fullnameKana = fullnameKana;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getRule() {
		return rule;
	}

	public void setRule(int rule) {
		this.rule = rule;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return loginName + "," + password + "," + salt + "," + rule;
	}
}
