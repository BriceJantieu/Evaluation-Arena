package com.ingesup.evaluationArena.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.ingesup.evaluationArena.hibernate.beans.Promo;
import com.ingesup.evaluationArena.tools.AuthentificateHttpServlet;
import com.ingesup.evaluationArena.tools.ConstantURL;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class CreatePromoServlet extends AuthentificateHttpServlet {

	private String urlCreatePromo;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlCreatePromo = getInitParameter("urlCreatePromo");
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

	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher(urlCreatePromo).forward(req, resp);
	}

	@Override
	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
			resp.sendRedirect(ConstantURL.DEFAULT_REDIRECT_STUDENT);
		
	}



	@Override
	public void doGetAdmin(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		// TODO Auto-generated method stub
		
	}
}
