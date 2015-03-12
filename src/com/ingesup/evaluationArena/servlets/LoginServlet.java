package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import net.sf.hibernate.HibernateException;

import com.ingesup.evaluationArena.hibernate.beans.Utilisateur;
import com.ingesup.evaluationArena.tools.HibernateUtil;
import com.ingesup.evaluationArena.tools.UserRole;

public class LoginServlet extends HttpServlet {
	
	private String urlLogin;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlLogin = getInitParameter("urlLogin");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// redirection vers la vue associée à l'action
		//response.sendRedirect("/EvaluationArena/questions/create");
		//response.sendRedirect("/EvaluationArena/questions.html");
		//response.sendRedirect("/EvaluationArena/examens/create");
		//response.sendRedirect("/EvaluationArena/categories/create");
		//response.sendRedirect("/EvaluationArena/matieres/create");
		//response.sendRedirect("/EvaluationArena/promos/create");
		//resp.sendRedirect("/EvaluationArena/promos.html");
		String path = req.getServletPath();
		if (path.equals("/logout.html"))
		{
			//logout
			HttpSession session = req.getSession();
			session.removeAttribute("userID");
			session.removeAttribute("userRole");
			resp.sendRedirect("/EvaluationArena/");
		}
		else
			getServletContext().getRequestDispatcher(urlLogin).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String path = req.getServletPath();
		if (path.equals("/login.html"))
		{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			
			List<Utilisateur> users = null;
			
			try {
				users = HibernateUtil.currentSession().find("from Utilisateur where Password LIKE '" + password + "' and Username LIKE '" + username + "'");
			} catch (HibernateException e) {
				String a = e.getMessage();
			}
			
			if(users != null && users.size() > 0) {
				Utilisateur connectedUser = users.get(0);
				
				HttpSession session = req.getSession();
				session.setAttribute("userID", connectedUser.getId().toString());
				session.setAttribute("userRole", connectedUser.getRole().getId().toString());
					
				resp.sendRedirect("/EvaluationArena/home.html");
				
			} else
				getServletContext().getRequestDispatcher(urlLogin).forward(req, resp);
				
		} else {
			//logout
			HttpSession session = req.getSession();
			session.removeAttribute("userID");
			session.removeAttribute("userRole");
		}
		
	}
	
	
}
