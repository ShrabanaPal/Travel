package com.submit;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class Logout extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		HttpSession session = request.getSession();
		session.removeAttribute("name");
		session.removeAttribute("email");
		session.removeAttribute("messege");
		
		session.invalidate();
		
		response.sendRedirect("login.jsp");
		
	}

}
