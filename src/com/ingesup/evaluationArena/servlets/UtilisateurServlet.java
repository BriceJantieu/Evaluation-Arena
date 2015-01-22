package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import com.ingesup.evaluationArena.hibernate.beans.Categorie;
import com.ingesup.evaluationArena.hibernate.beans.Role;
import com.ingesup.evaluationArena.hibernate.beans.Utilisateur;
import com.ingesup.evaluationArena.tools.HibernateUtil;

/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet(
		urlPatterns = { "/utilisateurs.html","/utilisateurs" }, 
		initParams = { 
				@WebInitParam(name = "urlUtilisateur", value = "/WEB-INF/views/utilisateurs/list.jsp", description = "Path de la view Utilisateurs(Liste)")
		})
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private String urlUtilisateur;
	
	private Role selectedRoleFilter;
	private List<Role> RoleList = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurServlet() {
        super();
        
        urlUtilisateur = "/WEB-INF/views/utilisateurs/list.jsp";//getInitParameter("urlUtilisateur");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if(RoleList == null)
			try {
				RoleList = HibernateUtil.currentSession().find("from Role");
			} catch (HibernateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		String FilterRoleId = request.getParameter("filter_role");
		String sqlRequest = "from Utilisateur";
		List<Utilisateur> users = null;
		
		if(FilterRoleId != null && !FilterRoleId.isEmpty())
		{
			sqlRequest += " where Role_Id = " + FilterRoleId;
			for (Role r : RoleList) {
				if(r.getId().toString().equals(FilterRoleId))
					selectedRoleFilter = r;
			}
		}
			
		
		try {
			users = HibernateUtil.currentSession().find(sqlRequest);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("roleList", RoleList );
		if(FilterRoleId == null || FilterRoleId.isEmpty())
			FilterRoleId = "0";
		request.setAttribute("selectedRoleId", FilterRoleId);
		request.setAttribute("utilisateurs", users);
		
		getServletContext().getRequestDispatcher(urlUtilisateur).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
