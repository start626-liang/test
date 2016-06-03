package servlet;

 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Message;
import dao.HeroDAO;
 

@WebServlet(asyncSupported = true, urlPatterns = { "/editHero" })
public class HeroEditServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        
        Message hero = new HeroDAO().get(id, type);
        request.setAttribute("hero", hero);
        request.getRequestDispatcher("editHero.jsp").forward(request, response);
    }
}