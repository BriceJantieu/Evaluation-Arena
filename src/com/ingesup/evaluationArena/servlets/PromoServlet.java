package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.ingesup.evaluationArena.hibernate.beans.Promo;
import com.ingesup.evaluationArena.hibernate.beans.Utilisateur;
import com.ingesup.evaluationArena.tools.AuthentificateHttpServlet;
import com.ingesup.evaluationArena.tools.ConstantURL;
import com.ingesup.evaluationArena.tools.HibernateUtil;
import com.ingesup.evaluationArena.tools.UserRole;

public class PromoServlet extends AuthentificateHttpServlet {

	private String urlPromos;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlPromos = getInitParameter("urlPromos");
	}
	
	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.sendRedirect("/EvaluationArena/home");
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
			resp.sendRedirect("/EvaluationArena/promos");
		} catch (HibernateException ignored) {
			resp.sendRedirect("EvaluationArena/promos");
		}
		
	}

	@Override
	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
			resp.sendRedirect(ConstantURL.DEFAULT_REDIRECT_STUDENT);
		
	}

	@Override
	public void doGetAdmin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		List<Promo> promos = null;
		
		try {
			promos = HibernateUtil.currentSession().find("from Promo");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("promos", promos);
		
		getServletContext().getRequestDispatcher(urlPromos).forward(req, resp);
	}	

}
