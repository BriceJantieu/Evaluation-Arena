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

import com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion;
import com.ingesup.evaluationArena.hibernate.beans.ExamenUtilisateur;
import com.ingesup.evaluationArena.hibernate.beans.ExmanenUtilisateur;
import com.ingesup.evaluationArena.hibernate.beans.Question;
import com.ingesup.evaluationArena.tools.AuthentificateHttpServlet;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class HomePageServlet extends AuthentificateHttpServlet {

	private String urlExamens;
	private String urlHomePageStudent;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlExamens = getInitParameter("urlExamens");
		urlHomePageStudent = getInitParameter("urlHomePageStudent");
	}
	
	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect(urlExamens);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String selectedExamenId = (String) req.getParameter("examenId");		
		if(selectedExamenId != null && !selectedExamenId.isEmpty())
			resp.sendRedirect("/EvaluationArena/examens/answer?examenId=" + selectedExamenId);
	}

	@Override
	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		HttpSession session = req.getSession();
		String userID = session.getAttribute("userID").toString();
		List<ExamenUtilisateur> examensUtilisateur = null;
		
		try {
			examensUtilisateur = HibernateUtil.currentSession().find("from ExamenUtilisateur where Utilisateur_ID =" + userID + " and isCompleted = 0");
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		Date today = new Date();
		List<ExamenUtilisateur> examensToDate = new ArrayList<>();
		for(ExamenUtilisateur eu : examensUtilisateur){
			if(eu.getExamen().getAvailable().after(today))
				examensToDate.add(eu);
		}
		
		req.setAttribute("examensUtilisateur", examensToDate);

		getServletContext().getRequestDispatcher(urlHomePageStudent).forward(req, resp);
		
	}



	@Override
	public void doGetAdmin(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.sendRedirect(urlExamens);
	}	

}
