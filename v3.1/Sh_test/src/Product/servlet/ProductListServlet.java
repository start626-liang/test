package Product.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.how2java.action.Action;
import com.how2java.pojo.Message;
import com.how2java.pojo.Product;
import com.how2java.pojo.Product_java;
import com.how2java.pojo.Product_other;
import com.how2java.pojo.Product_sql;

@WebServlet(asyncSupported = true, urlPatterns = { "/listProduct" })
public class ProductListServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String typeName = request.getParameter("typeName");
		
			
			if("java".equals(typeName)){
				List<Product_java> messages_java =  (List<Product_java>) new Action()._list("Product_java");
	
				request.setAttribute("heros", messages_java);
			}
			else if("sql".equals(typeName)){
				List<Product_sql> messages_sql =  (List<Product_sql>) new Action()._list("Product_sql");
				
				request.setAttribute("heros", messages_sql);
			}
			else if("other".equals(typeName)){
				List<Product_other> messages_other =  (List<Product_other>) new Action()._list("Product_other");
				
				request.setAttribute("heros", messages_other);
			}
			else{
				request.getRequestDispatcher("data.html").forward(request, response);
			}
			
			request.setAttribute("typeName", typeName);
			
			request.getRequestDispatcher("listProduct.jsp").forward(request, response);

	}
}