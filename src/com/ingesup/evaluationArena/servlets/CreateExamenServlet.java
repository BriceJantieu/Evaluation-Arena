package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import com.ingesup.evaluationArena.hibernate.beans.Categorie;
import com.ingesup.evaluationArena.hibernate.beans.Matiere;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class CreateExamenServlet extends HttpServlet {

	private String urlCreateExamen;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		urlCreateExamen = getInitParameter("urlCreateExamen");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Matiere> matieres = null;
		try {
			matieres = HibernateUtil.currentSession().find("from Matiere");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		
		req.setAttribute("matieres", matieres);
		
		getServletContext().getRequestDispatcher(urlCreateExamen).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String name = req.getParameter("name");
		String matiereId = req.getParameter("matiere");
		
		System.out.println("Id matière : " + matiereId);
	}
	

}
