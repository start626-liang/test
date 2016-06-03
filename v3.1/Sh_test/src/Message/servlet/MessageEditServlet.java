package Message.servlet;

 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.how2java.action.Action;
import com.how2java.action.MessageAction;
import com.how2java.pojo.Message;
import com.how2java.pojo.Product_java;
import com.how2java.pojo.Product_other;
import com.how2java.pojo.Product_sql;

 
 

@WebServlet(asyncSupported = true, urlPatterns = { "/editMessage" })
public class MessageEditServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String typeName = request.getParameter("typeName");
        
        Message message = null;
        
        
        message =  (Message) new Action().get(id, "message");
        request.setAttribute("hero", message);
        
        request.setAttribute("typeName", typeName);
        request.getRequestDispatcher("editMessage.jsp").forward(request, response);
    }
}