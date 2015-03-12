package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.ingesup.evaluationArena.hibernate.beans.Categorie;
import com.ingesup.evaluationArena.hibernate.beans.Matiere;
import com.ingesup.evaluationArena.hibernate.beans.Question;
import com.ingesup.evaluationArena.hibernate.beans.Reponse;
import com.ingesup.evaluationArena.tools.AuthentificateHttpServlet;
import com.ingesup.evaluationArena.tools.ConstantURL;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class QuestionServlet extends AuthentificateHttpServlet {

	private String urlQuestions;
	private List<Categorie> categories;
	private List<Categorie> allCategories;

	private String selectedMatiereId;

	@Override
	public void init() throws ServletException {
		super.init();

		urlQuestions = getInitParameter("urlQuestions");
	}
	
	private void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String selectedCategorieId = req.getParameter("categorie");
		if(req.getParameter("matiere") != null)
			selectedMatiereId = req.getParameter("matiere");
		
		if(selectedCategorieId == null || selectedCategorieId.isEmpty())
			selectedCategorieId = "0";
		
		if(selectedMatiereId == null || selectedMatiereId.isEmpty())
			selectedMatiereId = "0";
		
		List<Matiere> matieres = null;
		categories = null;
		List<Question> questions = null;
		
		String questionQuery = "from Question";
		String categoryQuery = "from Categorie";
		
		if(!selectedMatiereId.equals("0"))
			categoryQuery += " where Matiere_ID = " + selectedMatiereId;
		
		try {
			
			matieres = HibernateUtil.currentSession().find("from Matiere");
			categories = HibernateUtil.currentSession().find(categoryQuery);

			if(!selectedCategorieId.equals("0")){
				questionQuery += " where Categorie_ID = " + selectedCategorieId;
				questions = HibernateUtil.currentSession().find(questionQuery);
			} else if(!selectedMatiereId.equals("0"))
				questions = retrieveQuestions(selectedMatiereId);
			else
				questions = HibernateUtil.currentSession().find(questionQuery);
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}

		req.setAttribute("selectedCategorieId", selectedCategorieId);
		req.setAttribute("selectedMatiereId", selectedMatiereId);
		req.setAttribute("categories", categories);
		req.setAttribute("questions", questions);
		req.setAttribute("matieres", matieres);
		
		getServletContext().getRequestDispatcher(urlQuestions).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String questionContent = req.getParameter("question");
		String categorieId = req.getParameter("categorie");
		String rightResponse = req.getParameter("rightResponse");

		List<String> stringResponses = new ArrayList<String>();
		stringResponses.add(req.getParameter("response1"));
		stringResponses.add(req.getParameter("response2"));
		stringResponses.add(req.getParameter("response3"));
		stringResponses.add(req.getParameter("response4"));

		Categorie categorie = null;
		for (Categorie c : allCategories) {
			if (c.getId().toString().equals(categorieId))
				categorie = c;
		}

		Question q = new Question();
		q.setContent(questionContent);

		if (categorie != null)
			q.setCategorie(categorie);

		q.setCreateDate(Calendar.getInstance().getTime());

		try {
			Transaction t = HibernateUtil.currentSession().beginTransaction();
			HibernateUtil.currentSession().saveOrUpdate(q);
			t.commit();
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}

		for (int i = 0; i < stringResponses.size(); i++) {
			Reponse r = generateReponse(stringResponses.get(i),
					String.valueOf(i).equals(rightResponse));
			
			r.setQuestion(q);
			r.setName("");

			try {
				Transaction t = HibernateUtil.currentSession()
						.beginTransaction();
				HibernateUtil.currentSession().saveOrUpdate(r);
				t.commit();
			} catch (HibernateException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private Reponse generateReponse(String content, boolean isValid) {
		Reponse r = new Reponse();
		r.setContent(content);
		r.setIsValid(isValid);

		return r;
	}

	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		get(req, resp);
	}

	@Override
	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.sendRedirect(ConstantURL.DEFAULT_REDIRECT_STUDENT);
	}

	private List<Question> retrieveQuestions(String matiereId) {
		List<Question> questions = new ArrayList<Question>();

		Matiere selectedMatiere = null;

		try {
			List<Matiere> matieres = HibernateUtil.currentSession().find("from Matiere WHERE id = " + matiereId);
			if (matieres != null && matieres.size() > 0)
				selectedMatiere = matieres.get(0);
		} catch (HibernateException e) {
		}

		if (selectedMatiere != null) {
			Set<Categorie> categories = (Set<Categorie>) selectedMatiere.getCategorieSet();

			for (Categorie c : categories) {
				Set<Question> q = (Set<Question>) c.getQuestionSet();
				if (q != null)
					questions.addAll(q);
			}
		}

		return questions;
	}

	@Override
	public void doGetAdmin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		get(req, resp);
	}

}
