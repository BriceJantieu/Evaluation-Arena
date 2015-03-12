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
import com.ingesup.evaluationArena.tools.AuthentificateHttpServlet;
import com.ingesup.evaluationArena.tools.ConstantURL;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class CategoryServlet extends AuthentificateHttpServlet {

	private String urlCategories;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlCategories = getInitParameter("urlCategories");
	}

	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String selectedMatiereId = req.getParameter("matiere");
		
		if(selectedMatiereId == null || selectedMatiereId.isEmpty())
			selectedMatiereId = "0";
		
		String categorieQuery = "from Categorie";
		if(!selectedMatiereId.equals("0"))
			categorieQuery += " where Matiere_ID = " + selectedMatiereId;
		
		List<Matiere> matieres = null;
		List<Categorie> categories = null;
		
		try {
			
			matieres = HibernateUtil.currentSession().find("from Matiere");
			categories = HibernateUtil.currentSession().find(categorieQuery);
			
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}

		req.setAttribute("selectedMatiereId", selectedMatiereId);
		req.setAttribute("matieres", matieres);
		req.setAttribute("categories", categories);
		req.setAttribute("matieres", matieres);
		
		getServletContext().getRequestDispatcher(urlCategories).forward(req, resp);
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
			resp.sendRedirect("/EvaluationArena/categories");
		} catch (HibernateException ignored) {
			resp.sendRedirect("/EvaluationArena/categories");
		}
	}

	@Override
	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
			resp.sendRedirect(ConstantURL.DEFAULT_REDIRECT_STUDENT);
		
	}	

}
