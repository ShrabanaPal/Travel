package com.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.login.dao.LoginDao;

public class Login extends HttpServlet {
	
	public Login() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		String uemail = request.getParameter("uemail");
		String pass = request.getParameter("pass");
		
		LoginDao dao = new LoginDao();   //creating the object of Login-Dao
//		
//		if(uemail.equals("d2004@gmail.com") && pass.equals("1234") || uemail.equals("s25@gmail.com") && pass.equals("12345") ||
//		uemail.equals("u16@gmail.com") && pass.equals("9674") ||
//		uemail.equals("p20@gmail.com") && pass.equals("9830") ||
//		uemail.equals("su272004@gmail.com") && pass.equals("6291") ||
//		uemail.equals("a07@gmail.com") && pass.equals("9123")) {        //ist process	
		
		//2nd process
		
				try {
					if(dao.checks(uemail, pass)) {

						HttpSession session = request.getSession();
						session.setAttribute("email", uemail);
						session.setAttribute("password", pass);
						response.sendRedirect("contact.jsp");
						
						System.out.println("hi");
					}
					
					else {
						response.sendRedirect("login.jsp");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	}

}
