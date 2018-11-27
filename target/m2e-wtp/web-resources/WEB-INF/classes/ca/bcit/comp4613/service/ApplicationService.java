package ca.bcit.comp4613.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.bcit.comp4613.dao.DBBean;
import ca.bcit.comp4613.dao.Employee;
import ca.bcit.comp4613.utility.Response;
import ca.bcit.comp4613.utility.Utility;

public class ApplicationService implements IApplicationService{
	
	private String driver;
    private String url;
    private String user;
    private String password;
	private DBBean db;
	
	public ApplicationService(String driver, String url, String user, String password) {

		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
		System.out.println(driver + " :: " + url + " :: " + user + " :: " + password);
		db = new DBBean();
		db.connect(driver, url, user, password); //connect with db		
	}

	
	//take request from Controller and returns Response msg and code
	public Response doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestedAction = request.getParameter("button");
		
		//for success status db operations are performed
		if(request.getAttribute("status").equals("success")) {			
			try {
				return selectOperation(request, requestedAction);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return new Response("901","invalid employee data!"); //for invalid user input (id) db operation is not performed
	}
	
	
	//this method selects which CRUD operation has to be performed
	private Response selectOperation(HttpServletRequest req, String requestedOperation) throws SQLException {
		
		Response responsedMessage = null;		
        switch(requestedOperation) 
        { 
            case "addEmployee": 
            	responsedMessage = addEmployee(req);
                break;
                
            case "findEmployee": 
            	responsedMessage = findEmployeeById(req);
                break; 
                
            case "deleteEmployee": 
            	responsedMessage = deleteEmployeeById(req);
                break;
                
            default: 
            	responsedMessage = null; 
            	break;
        } 
        
        return responsedMessage;
	}
	
	//call dao to insert data and returns Response code and msg
	@Override
	public Response addEmployee(HttpServletRequest request) {
	
		//for empty firstname and lastname returns error response
		if((request.getParameter("first_name") == null || request.getParameter("first_name").isEmpty()) ||
				(request.getParameter("last_name") == null || request.getParameter("last_name").isEmpty())) {
			return new Response("900", "please insert firstname and lastname!");
		}
			
		Response responsedMessage = null;
		Employee employee = new Employee(request.getParameter("id"),
				request.getParameter("first_name"), request.getParameter("last_name"),
				Utility.convertFromStringToDate(request.getParameter("dob")));
		
		try {
			int row = db.insert(employee);		
			if(row > 0) {
				return new Response("200", "Success");
			}
			
		} catch (SQLException e) {		
			String errMessage = "Violation of UNIQUE KEY constraint 'uc_A01062206_EmployeeID'"+". Cannot insert duplicate key in object 'dbo.A01062206_Employees'.";
			if(e.getMessage().equals(errMessage)) {
				return new Response("502", "ID already exists for another employee");
			}			
		}
		return responsedMessage;
	}
	
	
	//call dao to find emp by user input and returns Response code and msg
	@Override
	public Response findEmployeeById(HttpServletRequest request) {
		String id = request.getParameter("id");
		try {
			String empName = db.getEmployeeById(id);
			if(empName != null && !empName.isEmpty()) {
				return new Response("000", empName);
			}
			return new Response("801", "No match found");
		} catch (SQLException e) {
			return new Response("801", "No match found");
		}		
	}
	
	@Override
	public Response deleteEmployeeById(HttpServletRequest request) {
		try {
			int row = db.deleteEmployeeById(request.getParameter("id"));
			if(row == 1) {
				return new Response("001", "Deleted Successfully");
			}
			return new Response("902", "Delete Unsuccessfully");
			
		} catch (SQLException e) {
			return new Response("902", "Delete Unsuccessfully");
		}
	}
	
	
	//returns all the employee in the table
	public List<Employee> getEmployeeList() {
		try {
			return db.getAllEmployees();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public void cleanUp() {
		//db.cleanUp();		
	}
}
