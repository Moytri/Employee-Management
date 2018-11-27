package ca.bcit.comp4613.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = "/app/*", servletNames = {"ApplicationServlet"})
public class AuthenticationFilter implements Filter{

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		System.out.println(req.isUserInRole("user"));
		if(req.isUserInRole("user")) {
			req.setAttribute("role", "user");
			req.setAttribute("page", "user/index.jsp");
		}
		
		if(req.isUserInRole("admin")) {
			req.setAttribute("role", "admin");
			req.setAttribute("page", "admin/index.jsp");
		}
		
		if(req.getMethod().equalsIgnoreCase("post")) {			
			String status = idValidation(req);	
			req.setAttribute("status", status);
		}
		
		chain.doFilter(req, res);		
	}

	//filtering id according to the business requirement
	//send success or error status based on logic
	//this method is used to validate ID for add, search, and remove employee operation
	private String idValidation(HttpServletRequest req) {

		String regex = "^A0[0-9]{7}";
		String id  = req.getParameter("id");

		String status = "success";
		
		boolean matches = Pattern.matches(regex, id);
		
		if(matches == false) {
			status = "error";
		}

		return status;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
