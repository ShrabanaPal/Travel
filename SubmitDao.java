package com.submit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubmitDao {

	String sql = "INSERT INTO travels(uname , uemail, umsg) VALUES (? , ? , ?)" ;   // insert the value and save it into database 
	String url ="jdbc:mysql://localhost:3306/contacts";
	String username = "root";
	String password = "Dona@1234#";
	
	public boolean check(String uname , String uemail , String umsg) throws SQLException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url , username , password);
			PreparedStatement st = con.prepareStatement(sql);   //passing the value so create a preparedStatement
//			PreparedStatement pt = con.prepareStatement(queryY); 
			
			st.setString(1, uname);    //for ist question mark is for user-name
			st.setString(2, uemail);   //for 2nd question mark is for user-email
			st.setString(3, umsg);   //for 3rd question mark is for user-messege
			
			int result =st.executeUpdate();
			
			if(result > 0) {
				return true;
			}
//		
//			pt.setString(1, uname);
//			pt.setString(2, uemail);
//			pt.setString(3, umsg);
////			
//			 ResultSet rs = pt.executeQuery();
//			 
//			 if(rs.next()) {
//				 return true;
//				 
//			 }
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		return false;  //by-default value
		
	}
}

