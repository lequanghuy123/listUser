/**
 * Copyright(C) 2020 Luvina Software Company
 * ,Common,15-07-2020, HuyLQ
 * 	
 */
package manageuser.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpSession;

import manageuser.entities.UserInfor;

/*
 * Class common chứa các phương thức chung 
 */
public class Common {

	/**
	 * Phương thức mã hóa passsword(salt,pass nhập vào) trả về pass đã được mã hóa
	 * SHA-1
	 */
	public String encriptPassWord(String salt, String passInput) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			String encryptedPass = salt + passInput;
			byte[] messageDigest = md.digest(encryptedPass.getBytes());
			return Base64.getEncoder().encodeToString(messageDigest);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Phương thức so sánh passMaHoa và passDB Trả về đúng và sai
	 */
	public boolean compareString(String encryptedPass, String passDB) {
		if (encryptedPass.equals(passDB)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEmpty(String name) {
		if ("".equals(name) || name.equals(null)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkLogin(HttpSession session) {
		if (!session.getAttribute("loginName").equals(null)) {
			return true;
		} else {
			return false;
		}
	}
}
