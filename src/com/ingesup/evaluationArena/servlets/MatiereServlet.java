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
import com.ingesup.evaluationArena.hibernate.beans.Promo;
import com.ingesup.evaluationArena.hibernate.beans.Utilisateur;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class MatiereServlet extends HttpServlet {

	private String urlMatieres;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlMatieres = getInitParameter("urlMatieres");
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
		
		getServletContext().getRequestDispatcher(urlMatieres).forward(req, resp);
		
	}	

}
