package Product.servlet;


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


@WebServlet(asyncSupported = true, urlPatterns = { "/updateProdect" })
public class ProdectUpdateServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String typeName = request.getParameter("typeName");
		Product_java java = null;
		Product_sql sql = null;
		Product_other other = null;
		
		if("java".equals(typeName)){
			java = new Product_java();
			
			java.setId(Integer.valueOf(request.getParameter("id")));
			java.setName(request.getParameter("name"));
			java.setContent(request.getParameter("content"));
			
			new Action().update(java, "java");
		}
		else if("sql".equals(typeName)){
			sql = new Product_sql();
			
			sql.setId(Integer.valueOf(request.getParameter("id")));
			sql.setName(request.getParameter("name"));
			sql.setContent(request.getParameter("content"));
			
			new Action().update(sql, "sql");
		}
		else if("other".equals(typeName)){
			other = new Product_other();
			
			other.setId(Integer.valueOf(request.getParameter("id")));
			other.setName(request.getParameter("name"));
			other.setContent(request.getParameter("content"));
			
			new Action().update(other, "other");
		}
		else{
			return;
		}
		
		request.setAttribute("typeName", typeName);
		response.sendRedirect("listProduct?typeName="+ typeName);

	}
}
