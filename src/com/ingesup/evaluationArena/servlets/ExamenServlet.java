package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;

import com.ingesup.evaluationArena.hibernate.beans.ExamenUtilisateur;
import com.ingesup.evaluationArena.hibernate.beans.ExmanenUtilisateur;
import com.ingesup.evaluationArena.tools.AuthentificateHttpServlet;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class ExamenServlet extends AuthentificateHttpServlet {

	private String urlExamens;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlExamens = getInitParameter("urlExamens");
	}

	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/EvaluationArena/home");
	}

	@Override
	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		HttpSession session = req.getSession();
		String userID = session.getAttribute("userID").toString();
		List<ExamenUtilisateur> examens = null;
		
		try {
			examens = HibernateUtil.currentSession().find("from ExamenUtilisateur where Utilisateur_ID =" + userID + " and isCompleted = 1");
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		
		req.setAttribute("examens", examens);

		getServletContext().getRequestDispatcher(urlExamens).forward(req, resp);
	}



	@Override
	public void doGetAdmin(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.sendRedirect("/EvaluationArena/home");
	}	

}
