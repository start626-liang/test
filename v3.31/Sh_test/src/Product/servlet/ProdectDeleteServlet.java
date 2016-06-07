package Product.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.how2java.action.Action;



@WebServlet(asyncSupported = true, urlPatterns = { "/deleteProdect" })
public class ProdectDeleteServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String typeName = request.getParameter("typeName");
		
			new Action().delete(id, typeName);
		

		response.sendRedirect("listProduct?typeName=" + typeName);
		
	}
}
