package cm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cm.service.RoleService;

@WebServlet(name = "role" , urlPatterns = "/roles")
public class RoleController extends HttpServlet{
	private RoleService roleService = new RoleService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("roles" , roleService.getAllRole());
		req.getRequestDispatcher("/role-table.jsp").forward(req, resp);
	}
}
