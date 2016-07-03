package interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map m = invocation.getInvocationContext().getSession();
		System.out.println(m.get("name")+"-------------------------");
		if(null == m.get("name")){
			ActionContext ctx = invocation.getInvocationContext().getContext();
			HttpServletResponse response = (HttpServletResponse) ctx.get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
			response.sendRedirect("login.jsp");
		}
		return invocation.invoke();
	}

}
