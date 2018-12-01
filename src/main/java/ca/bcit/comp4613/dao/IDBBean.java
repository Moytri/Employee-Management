package ca.bcit.comp4613.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDBBean {
	public void connect(String driver, String url, String user, String password);
	public List<Employee> getAllEmployees() throws SQLException;
	public int insert(Employee employee) throws SQLException;
	public String getEmployeeById(String id) throws SQLException;
	public int deleteEmployeeById(String id) throws SQLException;
	public void cleanUp();
}
