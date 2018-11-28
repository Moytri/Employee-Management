package ca.bcit.comp4613.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ca.bcit.comp4613.utility.Utility;

public class DBBean {

	private static Connection connection = null;
	private Statement statement = null;
	private ResultSet queryResults = null;
	

	public void connect(String driver, String url, String user, String password) {
		System.out.println("conn :: " + driver);
		try {			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("conn :: " + connection);
		}
		catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}		
	}
	

	public List<Employee> getAllEmployees() throws SQLException {

		List<Employee> emps = new ArrayList<Employee>();					
		String query = "Select * from A01062206_Employees";
		
		statement = connection.createStatement();
		queryResults = statement.executeQuery(query);
		
		while(queryResults.next()) {
			Employee emp = new Employee();
	
	    	emp.setID(queryResults.getString(1));
	    	emp.setFirstName(queryResults.getString(2));
	        emp.setLastName(queryResults.getString(3));
	        emp.setDob(Utility.convertFromSqlToUtil(queryResults.getDate(4)));
	        emps.add(emp);
		}
		
		return emps;
	}
	

	public int insert(Employee employee) throws SQLException{		
        PreparedStatement ps = null;
        String query = "INSERT INTO A01062206_Employees (ID, firstName, lastName, DOB) "
				+ "VALUES (?, ?, ?, ?)";
                
			ps = connection.prepareStatement(query);
			
		    ps.setString(1, employee.getID());	
		    ps.setString(2, employee.getFirstName());	
		    ps.setString(3, employee.getLastName());	
		    ps.setDate(4, Utility.convertFromUtiltoSql(employee.getDob()));
		    return ps.executeUpdate();
		    		
	}
	

	public String getEmployeeById(String id) throws SQLException {
		String query = "Select * from A01062206_Employees Where ID = '" + id.trim() + "' ";
		statement = connection.createStatement();
		queryResults = statement.executeQuery(query);
				
		if (queryResults.next()) {
			return queryResults.getString("firstName") + " " +  queryResults.getString("lastName");
		}				
		return null;
	}
	

	public int deleteEmployeeById(String id) throws SQLException {	
		statement = connection.createStatement();
		String query = "Delete from A01062206_Employees Where ID ='" + id.trim() + "' ";	
		return statement.executeUpdate(query);
	}
	

	public void cleanUp() {
		try {
			queryResults.close();
			statement.close();
			connection.close();
		} catch (SQLException sqlex) {
			sqlex.printStackTrace();
		}
	}

}
