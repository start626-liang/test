import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if ("a".equals(name) && "123".equals(password)) {
			System.out.println(1);
			request.getSession().setAttribute("userName", name);
			response.sendRedirect("main.html");
		} else {
			System.out.println(2);
			response.sendRedirect("login.html");
		}
	}
}