package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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
	
	private Categorie selectedCategorie;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlQuestions = getInitParameter("urlQuestions");
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
		
		List<Reponse> responses = new ArrayList<Reponse>();
		

		for(int i = 0; i < responses.size(); i++){
			Reponse r = generateReponse(stringResponses.get(i), String.valueOf(i).equals(rightResponse));
			responses.add(r);
			
			try {
				Transaction t = HibernateUtil.currentSession().beginTransaction();
				HibernateUtil.currentSession().saveOrUpdate(r);
				t.commit();
			} catch (HibernateException e) {
			}
		}
		
		Categorie categorie = null;
		for(Categorie c : categories){
			if(c.getId().toString().equals(categorieId))
				categorie = c;
		}
		
		Question q = new Question();
		q.setContent(questionContent);
		if(categorie != null)
			q.setCategorie(categorie);
		q.setCreateDate(Calendar.getInstance().getTime());
		
	}
	
	private Reponse generateReponse(String content, boolean isValid){
		Reponse r = new Reponse();
		r.setContent(content);
		r.setIsValid(isValid);
		
		return r;
	}


	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String selectedCategorieId = req.getParameter("categorie");
		String selectedMatiereId = req.getParameter("matiere");
		
		if(selectedCategorieId == null || selectedCategorieId.isEmpty())
			selectedCategorieId = "0";
		
		if(selectedMatiereId == null || selectedMatiereId.isEmpty())
			selectedMatiereId = "0";
		
		List<Matiere> matieres = null;
		
		if(selectedCategorieId == null || selectedCategorieId.isEmpty())
			selectedCategorieId = "0";

		categories = null;
		List<Question> questions = null;
		
		String questionQuery = "from Question";
		if(!selectedCategorieId.equals("0"))
			questionQuery += " where Categorie_ID = " + selectedCategorieId;
		
		try {
			
			matieres = HibernateUtil.currentSession().find("from Matiere");
			
			if(!selectedMatiereId.equals("0"))
				categories = HibernateUtil.currentSession().find("from Categorie where Matiere_ID = " + selectedMatiereId);
			//TODO ALLOU A WAK BAR
			categories = HibernateUtil.currentSession().find("from Categorie");

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
	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
			resp.sendRedirect(ConstantURL.DEFAULT_REDIRECT_STUDENT);
		
	}
	

}
