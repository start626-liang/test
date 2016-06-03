package servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Message;
import dao.HeroDAO;

@WebServlet(asyncSupported = true, urlPatterns = { "/listHero" })
public class HeroListServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = (String) request.getSession().getAttribute("userName");
		System.out.println("userName:" + userName);
		if (null == userName) {
			response.sendRedirect("login.html");
			return;
		}
		String type = request.getParameter("type");
		System.out.println(type);

		List<Message> heros = new HeroDAO().list(type);
		request.setAttribute("heros", heros);

		request.getRequestDispatcher("listHero.jsp").forward(request, response);

	}
}