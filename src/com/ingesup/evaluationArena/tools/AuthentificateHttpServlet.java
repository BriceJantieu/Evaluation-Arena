package com.ingesup.evaluationArena.tools;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class AuthentificateHttpServlet extends HttpServlet {
	
	private boolean isTeacher(String userRole)
	{
		return (Integer.valueOf(userRole) == UserRole.USER_TEACHER);
	}
	
	private boolean isAdmin(String userRole)
	{
		return (Integer.valueOf(userRole) == UserRole.USER_ADMIN);
	}
	
	private boolean isConnected(String userRole)
	{
		return (userRole != null);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String userRole = (String)session.getAttribute("userRole");
		if (isConnected(userRole))
		{
			if (isAdmin(userRole))
			{
				req.setAttribute("userRole", "admin");
				doGetAdmin(req, resp);
			}
			else if (isTeacher(userRole))
			{
				req.setAttribute("userRole", "teacher");
				doGetTeacher(req, resp);
			}
			else
			{

				req.setAttribute("userRole", "student");
				doGetStudent(req, resp);
			}
		}
		else
			resp.sendRedirect("/EvaluationArena/");
		
	}
	
	public abstract void doGetAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	public abstract void doGetTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	public abstract void doGetStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
