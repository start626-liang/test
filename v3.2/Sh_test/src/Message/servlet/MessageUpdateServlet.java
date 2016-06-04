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
		
		request.setAttribute("typeName", typeName);
		
		Message message = new Message();
		
		String proveName = request.getParameter("name");
		String proveContent = request.getParameter("content");
			
		if(30<proveName.length() || null==proveName || 8000<proveContent.length() || null==proveContent){
			response.sendRedirect("m_error.html");
			
			return;
		}
		else{
			message.setId(Integer.valueOf(request.getParameter("id")));
			message.setName(proveName);
			message.setContent(proveContent);
			
			new Action().update(message, "message");
			
			
			
			response.sendRedirect("listMessage?typeName="+ typeName);
		}
			
		

	}
}
