package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HeroDAO;

@WebServlet(asyncSupported = true, urlPatterns = { "/deleteHero" })
public class HeroDeleteServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		new HeroDAO().delete(id, type);

		response.sendRedirect("listHero?type=" + type);
		
	}
}
