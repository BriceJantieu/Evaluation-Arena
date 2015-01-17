package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
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
import com.ingesup.evaluationArena.tools.HibernateUtil;

/**
 * Servlet implementation class CreateUtilisateur
 */
@WebServlet(
		urlPatterns = { "/utilisateurs/create" }, 
		initParams = { 
				@WebInitParam(name = "urlCreateUtilisateur", value = "/WEB-INF/views/utilisateurs/create.jsp", description = "Path du fichier jsp de la vue")
		})
public class CreateUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;


private String urlCreateUtilisateur;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUtilisateur() {
        super();
        urlCreateUtilisateur = "/WEB-INF/views/utilisateurs/create.jsp";//getInitParameter("urlCreateUtilisateur").toString();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Role> groupes = null;
		try {
			groupes = HibernateUtil.currentSession().find("from Role");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("groupes", groupes);
		
		getServletContext().getRequestDispatcher(urlCreateUtilisateur).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String birthdate = request.getParameter("birthdate");
		String groupe = request.getParameter("groupe");
		
		System.out.println("Question créée.");
	}
}
