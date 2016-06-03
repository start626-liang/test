package servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Message;
import dao.HeroDAO;

@WebServlet(asyncSupported = true, urlPatterns = { "/updateHero" })
public class HeroUpdateServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String type = request.getParameter("type");
		
		Message hero = new Message();
		
		hero.setId(Integer.valueOf(request.getParameter("id")));
		hero.setName(request.getParameter("name"));
		hero.setContent(request.getParameter("content"));
		System.out.println(hero.getName() + "```````````" + hero.getContent() + "```````````" + hero.getId());

		new HeroDAO().update(hero, type);

		response.sendRedirect("listHero?type="+ type);

	}
}
