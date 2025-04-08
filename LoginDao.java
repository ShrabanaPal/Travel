//create a simple class called loginDao - login data access objects

package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.catalina.connector.Response;


public class LoginDao {

	String sql = "INSERT INTO log_schema (uemail, pass) VALUES (?, ?)" ;   // insert the value and save it into database 
	String query = "select * from log_schema where uemail ='?' and pass = '?' " ; //for manually fetching the value 
	String url ="jdbc:mysql://localhost:3306/log";
	String username = "root";
	String password = "Dona@1234#";
	
	public boolean checks(String uemail , String pass) throws SQLException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url , username , password);
			PreparedStatement st = con.prepareStatement(sql);   //passing the value so create a preparedStatement
			PreparedStatement pt = con.prepareStatement(query); 
			
			st.setString(1, uemail);   //for ist question mark is for user-email
			st.setString(2, pass);   //for 2nd question mark is for password
			
			int result =st.executeUpdate();
			
			if(result > 0) {
				return true;
			}
//		
			pt.setString(1, uemail);
			pt.setString(2, pass);
//			
			 ResultSet rs = pt.executeQuery();
			 
			 if(rs.next()) {
				 return true;
				 
			 }
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return false;  //by-default value
		
	}
}
