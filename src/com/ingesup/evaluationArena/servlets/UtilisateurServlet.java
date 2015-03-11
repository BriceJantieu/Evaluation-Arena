package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.ingesup.evaluationArena.tools.AuthentificateHttpServlet;
import com.ingesup.evaluationArena.tools.ConstantURL;
import com.ingesup.evaluationArena.tools.HibernateUtil;

/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet(
		urlPatterns = { "/utilisateurs.html","/utilisateurs" }, 
		initParams = { 
				@WebInitParam(name = "urlUtilisateur", value = "/WEB-INF/views/utilisateurs/list.jsp", description = "Path de la view Utilisateurs(Liste)")
		})
public class UtilisateurServlet extends AuthentificateHttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private String urlUtilisateur;
	
	private Role selectedRoleFilter;
	private List<Role> roleList = null;
	private SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurServlet() {
        super();
        
        urlUtilisateur = "/WEB-INF/views/utilisateurs/list.jsp";//getInitParameter("urlUtilisateur");
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
		newUser.setCreationDate(Calendar.getInstance().getTime());
		if(birthdate != null && !birthdate.isEmpty())
			try {
				newUser.setBirthDate(formater.parse(birthdate));
			} catch (ParseException e) {
				newUser.setBirthDate(null);
			}
		//newUser.setRole();
		if(roleList != null) {
			for (Role r : roleList) {
				if(r.getId().toString().equals(groupe))
					newUser.setRole(r);
			}
		}
		
		Transaction t = null;
		try {
			t = HibernateUtil.currentSession().beginTransaction();
			HibernateUtil.currentSession().saveOrUpdate(newUser);
			t.commit();

			response.sendRedirect("/EvaluationArena/users");
			
		} catch (HibernateException ignored) {

			response.sendRedirect("/EvaluationArena/users");
		}
	}

	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		if(roleList == null)
			try {
				roleList = HibernateUtil.currentSession().find("from Role");
			} catch (HibernateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		String FilterRoleId = req.getParameter("filter_role");
		String sqlRequest = "from Utilisateur";
		List<Utilisateur> users = null;
		
		if(FilterRoleId != null && !FilterRoleId.isEmpty())
		{
			sqlRequest += " where Role_Id = " + FilterRoleId;
			for (Role r : roleList) {
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
		
		req.setAttribute("roleList", roleList);
		if(FilterRoleId == null || FilterRoleId.isEmpty())
			FilterRoleId = "0";
		req.setAttribute("selectedRoleId", FilterRoleId);
		req.setAttribute("utilisateurs", users);
		
		getServletContext().getRequestDispatcher(urlUtilisateur).forward(req, resp);
	}

	@Override
	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
			resp.sendRedirect(ConstantURL.DEFAULT_REDIRECT_STUDENT);
		
	}

}
