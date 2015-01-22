package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import com.ingesup.evaluationArena.hibernate.beans.Promo;
import com.ingesup.evaluationArena.hibernate.beans.Utilisateur;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class PromoServlet extends HttpServlet {

	private String urlPromos;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlPromos = getInitParameter("urlPromos");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String selectedPromoId = req.getParameter("promo");
		
		if(selectedPromoId == null || selectedPromoId.isEmpty())
			selectedPromoId = "0";
		
		String utilisateurQuery = "from Utilisateur";
		if(!selectedPromoId.equals("0"))
			utilisateurQuery += " where Promo_ID = " + selectedPromoId;
		
		List<Promo> promos = null;
		List<Utilisateur> users = null;
		
		try {
			
			promos = HibernateUtil.currentSession().find("from Promo");
			users = HibernateUtil.currentSession().find(utilisateurQuery);
			
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}

		req.setAttribute("selectedPromoId", selectedPromoId);
		req.setAttribute("promos", promos);
		req.setAttribute("users", users);
		
		getServletContext().getRequestDispatcher(urlPromos).forward(req, resp);
	}	

}
