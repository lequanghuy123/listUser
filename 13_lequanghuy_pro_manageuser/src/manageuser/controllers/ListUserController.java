/**
 * Copyright(C) 2020 Luvina Software Company
 * ListUserController,15-07-2020, HuyLQ
 * 	
 */
package manageuser.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manageuser.entities.UserInfor;
import manageuser.logics.MstGroupLogic;
import manageuser.logics.TblUserLogic;
import manageuser.logics.impl.MstGroupLogicImpl;
import manageuser.logics.impl.TblUserLogicImpl;
import manageuser.utils.Common;

public class ListUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Class List UserController
	 * 
	 */
	public ListUserController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Phương thức : HttpServlet#doGet(HttpServletRequest request,
	 * HttpServletResponse response) Get request để hiển thị màn ADM002
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		RequestDispatcher requestDispatcher = null;
		List<String> listGroup = new ArrayList<String>();
		List<UserInfor> lisUserInfors = new ArrayList<UserInfor>();
		MstGroupLogic mstGroupLogicImpl = new MstGroupLogicImpl();
		TblUserLogic tblUserLogicImpl = new TblUserLogicImpl();
		Common common = new Common();
		String name = request.getParameter("name");
		String loginName = (String) session.getAttribute("loginName"); // lấy về loginname ở trên session
		System.out.println(loginName);
		String action = request.getParameter("action");
		System.out.println(action);
		System.out.println(name);
		try {
			if (common.checkLogin(session)){
				if (action.equals("load")) {
					listGroup = mstGroupLogicImpl.getAllMstGroup();
					lisUserInfors = tblUserLogicImpl.getListUser(0, 5, 0, name, "abc", "asc", "asc", "desc");
					request.setAttribute("loginName", loginName); // gắn login name lên req
					request.setAttribute("listGroup", listGroup);
					request.setAttribute("listUserInfors", lisUserInfors);
					requestDispatcher = request.getRequestDispatcher("/view/jsp/ADM002.jsp"); // hiển thị ADM002
				}
			} else {
				// nếu session ko tồn tại thfi về ADM001
				requestDispatcher = request.getRequestDispatcher("/login.do");
			}
			// forward req và resp
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			// nếu có lỗi về system error
			requestDispatcher = request.getRequestDispatcher("/view/jsp/SystemError.jsp");
			System.out.println("ListUserController" + ":" + e.getMessage());
		}
	}

	/**
	 * Phương thức HttpServlet#doPost(HttpServletRequest request,
	 * HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
	}

}
