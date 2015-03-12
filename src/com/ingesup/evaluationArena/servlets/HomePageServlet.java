package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;

import com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion;
import com.ingesup.evaluationArena.hibernate.beans.ExmanenUtilisateur;
import com.ingesup.evaluationArena.hibernate.beans.Question;
import com.ingesup.evaluationArena.tools.AuthentificateHttpServlet;
import com.ingesup.evaluationArena.tools.HibernateUtil;

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
		HttpSession session = req.getSession();
		String userID = session.getAttribute("userID").toString();
		List<ExamenQuestion> examenQ = null;
		List<Question> questions = new ArrayList<>();
		try {
			examenQ = HibernateUtil.currentSession().find("from Examen_Question where Examen_ID = 12");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		if (examenQ != null)
		{
			for (ExamenQuestion eq : examenQ)
			{
				try {
					questions.addAll(HibernateUtil.currentSession().find("from Question where Question_ID =" + eq.getQuestion()));
				} catch (HibernateException e) {
					e.printStackTrace();
				}
			}
		}
		req.setAttribute("questions", questions);
		getServletContext().getRequestDispatcher(urlHomePageTeacher).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	
	}

	@Override
	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		HttpSession session = req.getSession();
		String userID = session.getAttribute("userID").toString();
		List<ExmanenUtilisateur> examens = null;
		
		try {
			examens = HibernateUtil.currentSession().find("from ExamenUtilisateur where Utilisateur_ID =" + userID + " and isCompleted = 0");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("examens", examens);
		
		getServletContext().getRequestDispatcher(urlHomePageStudent).forward(req, resp);
		
	}



	@Override
	public void doGetAdmin(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		String userID = session.getAttribute("userID").toString();
		List<ExamenQuestion> examenQ = null;
		List<Question> questions = new ArrayList<>();
		try {
			examenQ = HibernateUtil.currentSession().find("from ExamenQuestion where Examen_ID = 12");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		if (examenQ != null)
		{
			for (ExamenQuestion eq : examenQ)
			{
				
				questions.add(eq.getQuestion());
			}
		}
		req.setAttribute("questions", questions);
		getServletContext().getRequestDispatcher(urlHomePageAdmin).forward(req, resp);
	}	

}
