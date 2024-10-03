package cm.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cm.common.Constant;
import cm.payload.ResponseData;
import cm.service.RoleService;

@WebServlet(name = "roleApi"  , urlPatterns = {Constant.URL_ROLE_DELETE , Constant.URL_ROLE_ADD})
public class RoleApi extends HttpServlet {
	private RoleService roleService = new RoleService();
	private Gson gson = new Gson();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String urlPath = req.getServletPath();
		switch (urlPath) {
		case Constant.URL_ROLE_DELETE:
			deleteRole(req, resp);
			break;
		case Constant.URL_ROLE_ADD:
			addRole(req, resp);
			break;
		default:
			break;
		}
	}
	private void deleteRole(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		boolean isSucess = roleService.deletRoleById(id);
		ResponseData responseData = new ResponseData();
		
		responseData.setSucess(isSucess);
		responseData.setDescription("");
		responseData.setData("");
		
		String json = gson.toJson(responseData);
		
		resp.setContentType("application/json");
		PrintWriter printWriter = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");
		printWriter.print(json);
		printWriter.flush();
	}
	private void addRole(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String rolename = req.getParameter("rolename");
		
		boolean isSucess = roleService.addRole(rolename);
		ResponseData responseData = new ResponseData();
		
		responseData.setSucess(isSucess);
		responseData.setDescription("");
		responseData.setData("");
		
		String json = gson.toJson(responseData);
		
		resp.setContentType("application/json");
		PrintWriter printWriter = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");
		printWriter.print(json);
		printWriter.flush();
	}
}
