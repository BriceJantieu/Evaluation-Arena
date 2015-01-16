package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
	private String urlHome;
	private String action;
	
	
	
	public void init(){
		urlHome = getInitParameter("urlHome");
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		// redirection vers la vue associée à l'action
		getServletContext().getRequestDispatcher(urlHome).forward(request, response);
	}
}
