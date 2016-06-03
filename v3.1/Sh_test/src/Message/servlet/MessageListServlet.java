package Message.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.how2java.action.Action;
import com.how2java.pojo.Message;

@WebServlet(asyncSupported = true, urlPatterns = { "/listMessage" })
public class MessageListServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String typeName = request.getParameter("typeName");
		
		List<Message> messages =  (List<Message>) new Action()._list("Message");
		request.setAttribute("heros", messages);
		
		
	
		request.setAttribute("typeName", typeName);
		request.getRequestDispatcher("listMessage.jsp").forward(request, response);

	}
}