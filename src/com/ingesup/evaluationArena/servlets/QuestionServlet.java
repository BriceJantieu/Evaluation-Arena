package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import com.ingesup.evaluationArena.hibernate.beans.Categorie;
import com.ingesup.evaluationArena.hibernate.beans.Matiere;
import com.ingesup.evaluationArena.hibernate.beans.Question;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class QuestionServlet extends HttpServlet {

	private String urlQuestions;
	
	private Categorie selectedCategorie;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlQuestions = getInitParameter("urlQuestions");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String selectedCategorieId = req.getParameter("categorie");
		String selectedMatiereId = req.getParameter("matiere");
		
		if(selectedCategorieId == null || selectedCategorieId.isEmpty())
			selectedCategorieId = "0";
		
		if(selectedMatiereId == null || selectedMatiereId.isEmpty())
			selectedMatiereId = "0";
		
		List<Matiere> matieres = null;
		
		if(selectedCategorieId == null || selectedCategorieId.isEmpty())
			selectedCategorieId = "0";

		List<Categorie> categories = null;
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
		
		System.out.println("Categorie Sélectionnée : " + selectedCategorieId);

		req.setAttribute("selectedCategorieId", selectedCategorieId);
		req.setAttribute("categories", categories);
		req.setAttribute("questions", questions);
		
		getServletContext().getRequestDispatcher(urlQuestions).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	

}
