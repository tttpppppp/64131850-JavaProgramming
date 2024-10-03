package cm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cm.service.LoginService;

@WebServlet(name = "loginUser" , urlPatterns = "/login")
public class LoginController extends HttpServlet {
	private LoginService loginService = new LoginService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		boolean isSuccess = loginService.checkLogin(email, password);
		
		if(isSuccess) {
			resp.sendRedirect(req.getContextPath() + "/hello");
		}else {
			req.setAttribute("errorMessage", "Invalid email or password.");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		}
	}
}
