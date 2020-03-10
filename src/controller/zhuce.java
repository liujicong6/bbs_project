package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StringUtils;


import pojo.user;
import service.userService;

/**
 * Servlet implementation class zhuce
 */
@WebServlet("/zhuce")
public class zhuce extends HttpServlet {
	private static final long serialVersionUID = 1L;
       userService userService=new userService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String userPsw = request.getParameter("userPsw");
		String reuserPsw = request.getParameter("reuserPsw");
		String userAlice = request.getParameter("userAlice");
		String userEmail = request.getParameter("userEmail");
		String userSex = request.getParameter("userSex");
		String userPhoto = request.getParameter("userPhoto");
		
		
		
		
		if(StringUtils.isNullOrEmpty(userId) || StringUtils.isNullOrEmpty(userPsw) 
				|| StringUtils.isNullOrEmpty(reuserPsw) 
				|| StringUtils.isNullOrEmpty(userAlice)
				|| StringUtils.isNullOrEmpty(userEmail)
				|| StringUtils.isNullOrEmpty(userSex)
				|| StringUtils.isNullOrEmpty(userPhoto)
				) {
			request.setAttribute("error","任何信息都不能为空");
			request.getRequestDispatcher("editor.jsp").forward(request, response);
			return;
		}
		if(userPsw.equals(reuserPsw) == false) {
			request.setAttribute("error","密码和确认密码必须相同");
			request.getRequestDispatcher("editor.jsp").forward(request, response);
			return;
		}
		
		if(userService.findUserById(userId) != null) {//判断一般账户是否存在
			request.setAttribute("error","账户已经存在");
			request.getRequestDispatcher("editor.jsp").forward(request, response);
			return;
		}
		user user = new user(userId, reuserPsw, userEmail, userPhoto, userAlice, userSex);
		userService.addBookUser(user);
	
		response.sendRedirect("login.jsp");
		return;
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
