package Product.servlet;

 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.how2java.action.Action;
import com.how2java.pojo.Product_java;
import com.how2java.pojo.Product_other;
import com.how2java.pojo.Product_sql;

 
 

@WebServlet(asyncSupported = true, urlPatterns = { "/editProduct" })
public class ProductEditServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String userName = (String) request.getSession().getAttribute("userName");

    	if (null == userName) {
    		response.sendRedirect("login.html");
    		return;
    	}
    	
        int id = Integer.parseInt(request.getParameter("id"));
        String typeName = request.getParameter("typeName");
        Product_java java = null;
        Product_sql sql = null;
        Product_other other = null;
        
        if("java".equals(typeName)){
        	 java =  (Product_java) new Action().get(id, "java");
        	 request.setAttribute("hero", java);
        }
        else if("sql".equals(typeName)){
        	sql =  (Product_sql) new Action().get(id, "sql");
       	 	request.setAttribute("hero", sql);
        }
        else if("other".equals(typeName)){
        	other =  (Product_other) new Action().get(id, "other");
       	 	request.setAttribute("hero", other);
        }
        else{
        	request.getRequestDispatcher("main.html");
        }
        System.out.println(typeName+"---------------"+id);
        request.setAttribute("typeName", typeName);
        request.getRequestDispatcher("editProduct.jsp").forward(request, response);
    }
}