/**
 * Copyright(C) 2020 Luvina Software Company
 * LogoutController,15-07-2020, HuyLQ
 * 	
 */
package manageuser.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Class Servlet cho action Logout 
 * @author HuyLQ
 */
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
/**
 * Phương thức doGet Nhận req từ màn ADM002 action logout để xóa session và quay về màn hình ADM001
 * 
 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// hiển thị ADM001
		//lấy về session
		HttpSession session = req.getSession();
		// xóa toàn bộ session tồn tại 
		session.invalidate();
		//forward req, resp
		resp.sendRedirect("login.do");
		
	}
}
