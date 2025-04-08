package com.submit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.submit.dao.SubmitDao;


public class Submit extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String umsg = request.getParameter("umsg");
		
		SubmitDao dao = new SubmitDao();
		
//		if(uname.equals("Dona pal") && uemail.equals("d2004@gmail.com") && umsg.equals("happy journey") || 
//				uname.equals("sona pal") && uemail.equals("s25@gmail.com") && umsg.equals("happy travel") ||
//				uname.equals("Usha pal") && uemail.equals("u16@gmail.com") && umsg.equals("enjoy journey") ||
//				uname.equals("Pradip pal") && uemail.equals("p20@gmail.com") && umsg.equals("comfort journey") ||
//				uname.equals("Subho pal") && uemail.equals("s27@gmail.com") && umsg.equals("happy life") ||
//				uname.equals("Ani pal") && uemail.equals("a07@gmail.com") && umsg.equals("miracle journey")) {
		
		try {
			if(dao.check(uname, uemail, umsg)) {
				
				HttpSession session = request.getSession();
				session.setAttribute("name", uname);
				session.setAttribute("email", uemail);
				session.setAttribute("messege", umsg);
				response.sendRedirect("login.jsp");
			}
			
			else {
				response.sendRedirect("contact.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

