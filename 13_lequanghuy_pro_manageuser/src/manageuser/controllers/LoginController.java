/**
 * Copyright(C) 2020 Luvina Software Company
 * LoginController,15-07-2020, HuyLQ
 * 	
 */
package manageuser.controllers;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.validates.ValidateUser;

/**
 * Class servlet Login Controller
 * @author HuyLQ
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Phương thức doGet nhận request từ action Logout để di chuyển về màn hình Login
	 * @param : request
	 * @param : resp
	 * 
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("/view/jsp/ADM001.jsp");
		requestDispatcher.forward(request, response);
	}
	/**
	 * Phương thức doPost di chuyển tới màn ADM002 nếu loginName và mật khẩu đúng, nếu sai ở lại màn ADM001 và in list Lỗi 
	 * @param : request
	 * @param : resp
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String loginName = req.getParameter("loginName");// lấy loginname
		String passInput = req.getParameter("password"); // lấy pass
		ValidateUser validateUser = new ValidateUser(); 
		RequestDispatcher requestDispatcher = null;
		ArrayList<String> listError = null;
		try {
			//gọi hàm validate loginName và pass nếu có lỗi sẽ đổ dữ liu vào listErr
			listError = validateUser.validateLogin(loginName, passInput); 
			// nếu list trống 
			if (listError.size() != 0) {         // 
				req.setAttribute("listError", listError); // gán list lỗi lên request
				req.setAttribute("loginName", loginName); // gán loginame lên request
				requestDispatcher = req.getRequestDispatcher("/view/jsp/ADM001.jsp"); // quay lại màn ADM001
				requestDispatcher.forward(req, resp); // forward request
			} else {
				HttpSession session = req.getSession(true);  //tạo session
				session.setAttribute("loginName", loginName); // lưu loginname lên session
				resp.sendRedirect(req.getContextPath() + "/listUser.do?action=load"); //chuyển hướng tới ListUserController
			}
		} catch (Exception e) {
			// nếu có lỗi di chuyển sang màn hình lỗi 
			resp.sendRedirect("view/jsp/SystemError.jsp");
			System.out.println(e.getClass()+":"+e.getMessage());
		}
	}
}
