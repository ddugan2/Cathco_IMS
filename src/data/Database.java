package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;

	public Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cims", "root", "password");
			System.out.println("Database Connected");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkLogin(String employeeID, String password) {
		System.out.println("Made it to checkLogin");
		
		String sqlStatement = "SELECT COUNT(*) "
							+ "FROM employees "
							+ "WHERE employee_id = " + employeeID 
							+ " AND employee_password = '" + password + "'";
		
		try {
			resultSet = statement.executeQuery(sqlStatement);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(resultSet.toString());
		
		return false;
	}
	
}
