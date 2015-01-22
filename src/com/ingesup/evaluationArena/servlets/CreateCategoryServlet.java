package com.ingesup.evaluationArena.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import com.ingesup.evaluationArena.hibernate.beans.Categorie;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class CreateCategoryServlet extends HttpServlet {

	private String urlCreateCategorie;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlCreateCategorie = getInitParameter("urlCreateCategorie");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher(urlCreateCategorie).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String name = req.getParameter("name");
		Categorie c = new Categorie();
		c.setName(name);
		try {
			HibernateUtil.currentSession().save(c);
		} catch (HibernateException ignored) {}
	}	

}
