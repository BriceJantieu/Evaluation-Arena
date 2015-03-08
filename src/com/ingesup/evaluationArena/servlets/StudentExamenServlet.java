package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;
import com.ingesup.evaluationArena.hibernate.beans.ExmanenUtilisateur;
import com.ingesup.evaluationArena.tools.AuthentificateHttpServlet;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class StudentExamenServlet extends AuthentificateHttpServlet {

	private String urlStudentExamens;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlStudentExamens = getInitParameter("urlStudentExamens");
	}
	
	private void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String userID = session.getAttribute("userID").toString();
		List<ExmanenUtilisateur> examens = null;
		
		try {
			examens = HibernateUtil.currentSession().find("from ExmanenUtilisateur where Utilisateur_ID =" + userID);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		req.setAttribute("examens", examens);
		getServletContext().getRequestDispatcher(urlStudentExamens).forward(req, resp);
	}

	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.sendRedirect("/EvaluationArena/home");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
	}

	@Override
	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
			try {
				get(req,resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}



	@Override
	public void doGetAdmin(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		resp.sendRedirect("/EvaluationArena/home");
	}	

}
