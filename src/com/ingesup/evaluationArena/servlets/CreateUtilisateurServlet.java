package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.ingesup.evaluationArena.hibernate.beans.Categorie;
import com.ingesup.evaluationArena.hibernate.beans.Role;
import com.ingesup.evaluationArena.hibernate.beans.Utilisateur;
import com.ingesup.evaluationArena.tools.HibernateUtil;

/**
 * Servlet implementation class CreateUtilisateur
 */
@WebServlet(
		urlPatterns = { "/utilisateurs/create" }, 
		initParams = { 
				@WebInitParam(name = "urlCreateUtilisateur", value = "/WEB-INF/views/utilisateurs/create.jsp", description = "Path du fichier jsp de la vue")
		})
public class CreateUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


private String urlCreateUtilisateur;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUtilisateurServlet() {
        super();
        urlCreateUtilisateur = "/WEB-INF/views/utilisateurs/create.jsp";//getInitParameter("urlCreateUtilisateur").toString();
    }
    
    private SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
    private List<Role> Groupes = null;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Groupes = HibernateUtil.currentSession().find("from Role");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("groupes", Groupes);
		
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
		
		Utilisateur newUser = new Utilisateur();
		
		newUser.setUsername(username);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setFirstName(firstname);
		newUser.setLastName(lastname);
		if(birthdate != null && !birthdate.isEmpty())
			try {
				newUser.setBirthDate(formater.parse(birthdate));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		//newUser.setRole();
		if(Groupes != null)
		{
			for (Role r : Groupes) {
				if(r.getId().toString().equals(groupe))
					newUser.setRole(r);
			}
		}
		
		Transaction t = null;
		try {
			t = HibernateUtil.currentSession().beginTransaction();
			HibernateUtil.currentSession().saveOrUpdate(newUser);
			t.commit();
			
		} catch (HibernateException ignored) {}
	}
}
