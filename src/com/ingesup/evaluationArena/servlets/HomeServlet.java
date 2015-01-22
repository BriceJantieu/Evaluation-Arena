package com.ingesup.evaluationArena.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
	
	private String urlHome;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlHome = getInitParameter("urlHome");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		// redirection vers la vue associée à l'action
		//getServletContext().getRequestDispatcher(urlHome).forward(request, response);
		//response.sendRedirect("/EvaluationArena/questions/create");
		//response.sendRedirect("/EvaluationArena/questions.html");
		//response.sendRedirect("/EvaluationArena/examens/create");
		response.sendRedirect("/EvaluationArena/categories/create");
	}
}
