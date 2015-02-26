package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.ingesup.evaluationArena.hibernate.beans.Categorie;
import com.ingesup.evaluationArena.hibernate.beans.Matiere;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class CreateCategoryServlet extends HttpServlet {

	private String urlCreateCategorie;
	
	private List<Matiere> matieres;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlCreateCategorie = getInitParameter("urlCreateCategorie");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			matieres = HibernateUtil.currentSession().find("from Matiere");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		
		req.setAttribute("matieres", matieres);
		
		getServletContext().getRequestDispatcher(urlCreateCategorie).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String name = req.getParameter("name");
		String selectedMatiereId = req.getParameter("matiere");
		
		Matiere m = new Matiere();
		m.setId(Integer.valueOf(selectedMatiereId));
		
		Categorie c = new Categorie();
		c.setName(name);
		c.setMatiere(m);
		
		try {
			Transaction t = HibernateUtil.currentSession().beginTransaction();
			HibernateUtil.currentSession().saveOrUpdate(c);
			t.commit();
			
		} catch (HibernateException ignored) {}
	}	

}
