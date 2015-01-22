package com.ingesup.evaluationArena.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.ingesup.evaluationArena.hibernate.beans.Promo;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class CreatePromoServlet extends HttpServlet {

	private String urlCreatePromo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlCreatePromo = getInitParameter("urlCreatePromo");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher(urlCreatePromo).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String label = req.getParameter("label");
		
		Promo p = new Promo();
		p.setLibelle(label);
		
		try {
			Transaction t = HibernateUtil.currentSession().beginTransaction();
			HibernateUtil.currentSession().saveOrUpdate(p);
			t.commit();
			
		} catch (HibernateException ignored) {}
	}
}
