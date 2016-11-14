package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import service.LoginService;

public class MainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if("logoff".equals(op)){
			HttpSession session = request.getSession();
			session.removeAttribute("user");
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		User user = LoginService.login(name, password);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		response.getWriter().print(user==null?"0":"1");
	}
}
