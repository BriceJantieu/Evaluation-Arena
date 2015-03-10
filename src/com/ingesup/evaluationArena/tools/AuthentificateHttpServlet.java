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
			if (isTeacher(userRole))
				doGetTeacher(req, resp);
			else
				doGetStudent(req, resp);
		}
		else
			resp.sendRedirect("/EvaluationArena/");
		
	}
	
	public abstract void doGetTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
	public abstract void doGetStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException;
}
