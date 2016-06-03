package Message.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.how2java.action.Action;
import com.how2java.pojo.Message;
import com.how2java.pojo.Product_java;
import com.how2java.pojo.Product_other;
import com.how2java.pojo.Product_sql;


@WebServlet(asyncSupported = true, urlPatterns = { "/updateMessage" })
public class MessageUpdateServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String typeName = request.getParameter("typeName");
		
		Message message = new Message();
			
		message.setId(Integer.valueOf(request.getParameter("id")));
		message.setName(request.getParameter("name"));
		message.setContent(request.getParameter("content"));
			
		new Action().update(message, "message");
		
		
		request.setAttribute("typeName", typeName);
		response.sendRedirect("listMessage?typeName="+ typeName);

	}
}
