package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.codegen.IntegerCache;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.ingesup.evaluationArena.hibernate.beans.Categorie;
import com.ingesup.evaluationArena.hibernate.beans.Examen;
import com.ingesup.evaluationArena.hibernate.beans.ExamenPromo;
import com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion;
import com.ingesup.evaluationArena.hibernate.beans.ExmanenUtilisateur;
import com.ingesup.evaluationArena.hibernate.beans.Matiere;
import com.ingesup.evaluationArena.hibernate.beans.Promo;
import com.ingesup.evaluationArena.hibernate.beans.Question;
import com.ingesup.evaluationArena.hibernate.beans.Utilisateur;
import com.ingesup.evaluationArena.tools.AuthentificateHttpServlet;
import com.ingesup.evaluationArena.tools.ConstantURL;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class CreateExamenServlet extends AuthentificateHttpServlet {

	private String urlCreateExamen;
	private String urlExamens;
	
	//Il faut que ce soit une variable de classe car la matière est dans
	//un formulaire a part
	private String selectedMatiereId;
	private List<Promo> promos;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlCreateExamen = getInitParameter("urlCreateExamen");
		urlExamens = getInitParameter("urlExamens");
	}
	
	private void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		List<Matiere> matieres = null;
		List<Question> questions = null;
		promos = null;
		selectedMatiereId = req.getParameter("matiere");
		if(selectedMatiereId == null || selectedMatiereId.isEmpty())
			selectedMatiereId = "0";
		
		String categorieQuery = "from Categorie";
		if(!selectedMatiereId.equals("0"))
			categorieQuery += " where Matiere_ID = " + selectedMatiereId;
		
		try {
			matieres = HibernateUtil.currentSession().find("from Matiere");
			if (!selectedMatiereId.equals("0"))
			{
				Matiere matiere = null;
				for (Matiere m : matieres)
				{
					if (m.getId() == Integer.parseInt(selectedMatiereId))
					{
						matiere = m;
					}
				}
				if (matiere != null)
				{
					questions = retrieveQuestions(matiere);
				}
			}
			promos = HibernateUtil.currentSession().find("from Promo");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		
		req.setAttribute("matieres", matieres);
		req.setAttribute("selectedMatiereId", selectedMatiereId);
		req.setAttribute("questions", questions);
		req.setAttribute("promos", promos);
		
		getServletContext().getRequestDispatcher(urlCreateExamen).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Examen> examens = null;
		HttpSession session = req.getSession();
		String userID = session.getAttribute("userID").toString();
		
		if(selectedMatiereId == null || selectedMatiereId.equals("0"))
			return;
		
		
		String name = req.getParameter("name");
		String available = req.getParameter("date");

		Matiere examenMatiere = new Matiere();
		examenMatiere.setId(Integer.valueOf(selectedMatiereId));
		
		Utilisateur teacher = new Utilisateur();
		teacher.setId(Integer.valueOf(userID));
		
		Examen examen = new Examen();
		examen.setName(name);
		examen.setMatiere(examenMatiere);
		examen.setAvailable(Date.valueOf(available));
		examen.setTeacher(teacher);
		
		try {
			Transaction t = HibernateUtil.currentSession().beginTransaction();
			HibernateUtil.currentSession().saveOrUpdate(examen);
			t.commit();
			
		} catch (HibernateException ignored) {} 
		
		Enumeration<String> paramsName = req.getParameterNames();
		int order = 0;
		while (paramsName.hasMoreElements())
		{
			String paramName = paramsName.nextElement();
			if (paramName.contains("question"))
			{
				order ++;
				Question q = new Question();
				q.setId(Integer.parseInt(req.getParameter(paramName)));
				ExamenQuestion examQuest = new ExamenQuestion();
				examQuest.setQuestionOrder(order);
				examQuest.setId(null);
				examQuest.setExamen(examen);
				examQuest.setQuestion(q);
				try {
					Transaction t = HibernateUtil.currentSession().beginTransaction();
					HibernateUtil.currentSession().save(examQuest);
					t.commit();
					
				} catch (HibernateException ignored) {}
			
			}
			else if (paramName.contains("promo"))
			{
				for (Promo p : promos)
				{
					if (p.getId() == Integer.parseInt(req.getParameter(paramName)))
					{
						ExamenPromo ep = new ExamenPromo();
						ep.setExamen(examen);
						ep.setPromo(p);
						try {
							Transaction t = HibernateUtil.currentSession().beginTransaction();
							HibernateUtil.currentSession().save(ep);
							t.commit();
							
						} catch (HibernateException ignored) {}
						
						for (Object u : p.getUtilisateurSet())
						{
							Utilisateur user = (Utilisateur) u;
							ExmanenUtilisateur ex = new ExmanenUtilisateur();
							ex.setExamen(examen);
							ex.setUtilisateur(user);
							try {
								Transaction t = HibernateUtil.currentSession().beginTransaction();
								HibernateUtil.currentSession().save(ex);
								t.commit();
								
							} catch (HibernateException e) {
								e.printStackTrace();
							}
							
						}
					}
				}
				
			}
		}

		resp.sendRedirect(urlExamens);
		
	}

	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		get(req, resp);
	}

	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
			resp.sendRedirect(ConstantURL.DEFAULT_REDIRECT_STUDENT);
		
	}	
	
	private List<Question> retrieveQuestions(Matiere m) throws HibernateException{
	
		List<Question> questions = new ArrayList<>();
		for (Object c : m.getCategorieSet())
		{
			Categorie categ = (Categorie)c;
			List<Question> q =  HibernateUtil.currentSession().find("from Question where Categorie_ID = " + categ.getId());
			questions.addAll(q);
		}
		
		return questions;
	}


	@Override
	public void doGetAdmin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		get(req, resp);
	}

}
