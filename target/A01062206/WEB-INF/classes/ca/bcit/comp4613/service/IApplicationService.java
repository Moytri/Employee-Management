package ca.bcit.comp4613.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ca.bcit.comp4613.dao.Employee;
import ca.bcit.comp4613.utility.Response;

public interface IApplicationService {
	public List<Employee> getEmployeeList();
	public Response addEmployee(HttpServletRequest request);
	public Response findEmployeeById(HttpServletRequest request);
	public Response deleteEmployeeById(HttpServletRequest request);
}
