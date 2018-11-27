package ca.bcit.comp4613.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.bcit.comp4613.dao.DBBean;
import ca.bcit.comp4613.dao.Employee;
import ca.bcit.comp4613.service.ApplicationService;
import ca.bcit.comp4613.utility.Response;

@WebServlet(name = "ApplicationServlet", displayName = "ApplicationServlet", urlPatterns = "/app/*",
initParams = {@WebInitParam(name = "driver", value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"), //com.microsoft.sqlserver.jdbc.SQLServerDriver
@WebInitParam(name = "url", value = "jdbc:sqlserver://Beangrinder.bcit.ca"), //value = "jdbc:sqlserver://127.0.0.1:1443;instance=SQLEXPRESS;"
@WebInitParam(name = "db", value = "jspweb"),
@WebInitParam(name = "user", value = "javastudent"),
@WebInitParam(name = "password", value = "compjava")})
public class ApplicationServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private String driver;
    private String url;
    private String user;
    private String password;
	private DBBean db;
	ApplicationService service;
	
	//initialize servlet and here service is instantiated
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

        driver = config.getInitParameter("driver");
        url = config.getInitParameter("url");
        user = config.getInitParameter("user");
		password = config.getInitParameter("password");		
		service = new ApplicationService(driver, url, user, password);
	}

	//control comes to doGet from index.jsp
	//this method is just show the login page when application starts
	//then show index page according to user role
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = (String) request.getAttribute("page");
		List<Employee> emps = service.getEmployeeList();		//during page loading emps are read from the db
		request.setAttribute("emps", emps);
		
		if(pathInfo != null && !pathInfo.isEmpty()) {
			request.getRequestDispatcher(pathInfo).forward(request, response); //returns page based on user role
		}
		
		else {
			request.getRequestDispatcher("application/login.jsp").forward(request, response); //returns login page
		}
	}

	//called when any of the submit button is pressed from the user/admin index page
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("role", request.getParameter("role"));
		Response message = service.doPost(request, response);	//call service for all business logic
		request.setAttribute("message", message);
		
		List<Employee> emps = service.getEmployeeList();
		request.setAttribute("emps", emps);

		//role is a hidden field comes from findEmployee.jsp page to distinguish the search by user/admin
		if(request.getAttribute("role")!= null && request.getAttribute("role").equals("user")) {
			request.getRequestDispatcher("user/index.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
	}
	
	@Override
	public void destroy() {
		//db.cleanUp();
	}
	
}
