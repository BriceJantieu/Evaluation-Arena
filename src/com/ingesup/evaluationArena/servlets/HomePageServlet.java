package com.ingesup.evaluationArena.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ingesup.evaluationArena.tools.AuthentificateHttpServlet;

public class HomePageServlet extends AuthentificateHttpServlet {

	private String urlHomePageTeacher;
	private String urlHomePageAdmin;
	private String urlHomePageStudent;
	
	@Override
	public void init() throws ServletException {
		super.init();
		urlHomePageTeacher = getInitParameter("urlHomePageTeacher");
		urlHomePageStudent = getInitParameter("urlHomePageStudent");
		urlHomePageAdmin = getInitParameter("urlHomePageAdmin");
	}
	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher(urlHomePageTeacher).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	
	}

	@Override
	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		try {
			getServletContext().getRequestDispatcher(urlHomePageStudent).forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public void doGetAdmin(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher(urlHomePageAdmin).forward(req, resp);
	}	

}
