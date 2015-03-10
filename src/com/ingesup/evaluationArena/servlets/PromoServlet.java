package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;

import com.ingesup.evaluationArena.hibernate.beans.Promo;
import com.ingesup.evaluationArena.hibernate.beans.Utilisateur;
import com.ingesup.evaluationArena.tools.AuthentificateHttpServlet;
import com.ingesup.evaluationArena.tools.ConstantURL;
import com.ingesup.evaluationArena.tools.HibernateUtil;
import com.ingesup.evaluationArena.tools.UserRole;

public class PromoServlet extends AuthentificateHttpServlet {

	private String urlPromos;
	private String urlHome;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlPromos = getInitParameter("urlPromos");
		urlHome = getInitParameter("urlHome");
	}
	
	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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

	@Override
	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
			resp.sendRedirect(ConstantURL.DEFAULT_REDIRECT_STUDENT);
		
	}	

}
