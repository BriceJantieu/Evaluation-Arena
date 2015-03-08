package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
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
	
	//Il faut que ce soit une variable de classe car la matière est dans
	//un formulaire a part
	private String selectedMatiereId;
	private List<Promo> promos;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlCreateExamen = getInitParameter("urlCreateExamen");
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(selectedMatiereId == null || selectedMatiereId.equals("0"))
			return;
		
		//examen = Matiere + Name + CreateBy
		//examen+question = examen_ID + question_ID + order
		//examen+users
		String name = req.getParameter("name");
		HttpSession session = req.getSession();
		String userID = (String)session.getAttribute("userID");
		List<Promo> lstPromos = new ArrayList<Promo>();
		Matiere examenMatiere = new Matiere();
		examenMatiere.setId(Integer.valueOf(selectedMatiereId));
		
		Examen examen = new Examen();
		examen.setName(name);
		examen.setMatiere(examenMatiere);
		examen.setCreatedBy(userID);
		examen.setCreateDate(Calendar.getInstance().getTime());
		
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
							Utilisateur user = (Utilisateur)u;
							ExmanenUtilisateur ex = new ExmanenUtilisateur();
							ex.setExamen(examen);
							ex.setUtilisateur(user);
							try {
								Transaction t = HibernateUtil.currentSession().beginTransaction();
								HibernateUtil.currentSession().save(ex);
								t.commit();
								
							} catch (HibernateException ignored) {}
							
						}
					}
				}
				
			}
		}
		/*ExamenPromo examenPromo = new ExamenPromo();
		examenPromo.setPromo(promo);
		
		Promo promo = new Promo();
		promo.setId(Integer.valueOf(promos[0]));*/
		
		
		
		
	}

	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
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
			questions = retrieveQuestions(selectedMatiereId);
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

	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
			resp.sendRedirect(ConstantURL.DEFAULT_REDIRECT_STUDENT);
		
	}	
	
	private List<Question> retrieveQuestions(String matiereId) throws HibernateException{
		if(matiereId == null || matiereId.equals("0"))
			return null;
		
		List<Question> questions = HibernateUtil.currentSession().find("from Question");
		List<Categorie> categories = HibernateUtil.currentSession().find("from Categorie where Matiere_ID = " + matiereId);
	
		if(categories == null || categories.size() <= 0)
			return null;
		
		List<Question> questionsToReturn = new ArrayList<>();
		
		for(Question q : questions){
			if(q.getCategorie().getId() == categories.get(0).getId())
				questionsToReturn.add(q);
		}
		
		return questionsToReturn;
	}

}
