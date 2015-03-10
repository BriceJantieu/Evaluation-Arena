package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.ingesup.evaluationArena.hibernate.beans.Categorie;
import com.ingesup.evaluationArena.hibernate.beans.Examen;
import com.ingesup.evaluationArena.hibernate.beans.ExamenPromo;
import com.ingesup.evaluationArena.hibernate.beans.Matiere;
import com.ingesup.evaluationArena.hibernate.beans.Promo;
import com.ingesup.evaluationArena.hibernate.beans.Question;
import com.ingesup.evaluationArena.tools.AuthentificateHttpServlet;
import com.ingesup.evaluationArena.tools.ConstantURL;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class CreateExamenServlet extends AuthentificateHttpServlet {

	private String urlCreateExamen;
	
	//Il faut que ce soit une variable de classe car la matière est dans
	//un formulaire a part
	private String selectedMatiereId;
	
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
		
		String name = req.getParameter("name");
		String[] questions = req.getParameterValues("questions");
		String[] promos = req.getParameterValues("promos");
		
		Matiere examenMatiere = new Matiere();
		examenMatiere.setId(Integer.valueOf(selectedMatiereId));
		
		/*ExamenPromo examenPromo = new ExamenPromo();
		examenPromo.setPromo(promo);
		
		Promo promo = new Promo();
		promo.setId(Integer.valueOf(promos[0]));*/
		
		Examen examen = new Examen();
		examen.setName(name);
		examen.setMatiere(examenMatiere);
		//TODO Actualiser le créateur de l'examen
		examen.setCreatedBy("Créateur");
		examen.setCreateDate(new Date());
		
		try {
			Transaction t = HibernateUtil.currentSession().beginTransaction();
			HibernateUtil.currentSession().saveOrUpdate(examen);
			t.commit();
			
		} catch (HibernateException ignored) {}
	}

	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		List<Matiere> matieres = null;
		List<Question> questions = null;
		List<Promo> promos = null;
		
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
