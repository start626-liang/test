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
		
		request.setAttribute("typeName", typeName);
		
		String proveName = request.getParameter("name");
		String proveContent = request.getParameter("content");
			
		if(100<proveName.length() || null==proveName || 600*1024<proveContent.length() || null==proveContent){
			
			if("java".equals(typeName)){
				
				response.sendRedirect("p_error_java.html");
			}
			else if("sql".equals(typeName)){
				response.sendRedirect("p_error_sql.html");
				
			}
			else if("other".equals(typeName)){
				response.sendRedirect("p_error_other.html");
				
			}
			
			
			return;
		}
		else{
			Product_java java = null;
			Product_sql sql = null;
			Product_other other = null;
			
			if("java".equals(typeName)){
				java = new Product_java();
				
				java.setId(Integer.valueOf(request.getParameter("id")));
				java.setName(proveName);
				java.setContent(proveContent);
				
				new Action().update(java, "java");
			}
			else if("sql".equals(typeName)){
				sql = new Product_sql();
				
				sql.setId(Integer.valueOf(request.getParameter("id")));
				sql.setName(proveName);
				sql.setContent(proveContent);
				
				new Action().update(sql, "sql");
			}
			else if("other".equals(typeName)){
				other = new Product_other();
				
				other.setId(Integer.valueOf(request.getParameter("id")));
				other.setName(proveName);
				other.setContent(proveContent);
				
				new Action().update(other, "other");
			}
			else{
				return;
			}
			
			
			response.sendRedirect("listProduct?typeName="+ typeName);
		}
	}
}
