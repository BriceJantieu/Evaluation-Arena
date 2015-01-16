package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuestionServlet extends HttpServlet {

	private String urlQuestions;
	
	private Matiere selectedMatiere;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlQuestions = getInitParameter("urlQuestions");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String selectedMatiereId = req.getParameter("matiere");
		if(selectedMatiereId == null || selectedMatiereId.isEmpty())
			selectedMatiereId = "0";
		
		List<Matiere> matieres = new ArrayList<Matiere>();
		Matiere matiere1 = new Matiere(1, "Matiere 1");
		Matiere matiere2 = new Matiere(2, "Matiere 2");
		Matiere matiere3 = new Matiere(3, "Matiere 3");
		Matiere matiere4 = new Matiere(4, "Matiere 4");
		
		matieres.add(matiere1);
		matieres.add(matiere2);
		matieres.add(matiere3);
		matieres.add(matiere4);
		
		List<Question> questions = new ArrayList<Question>();
		List<Question> selectedQuestions = new ArrayList<Question>();
		
		Question question1 = new Question(1, "Contenu 1", matiere1);
		Question question2 = new Question(2, "Contenu 2", matiere2);
		Question question3 = new Question(3, "Contenu 3", matiere2);
		Question question4 = new Question(4, "Contenu 4", matiere1);
		Question question5 = new Question(5, "Contenu 5", matiere1);
		
		questions.add(question1);
		questions.add(question2);
		questions.add(question3);
		questions.add(question4);
		questions.add(question5);
		
		for(Question q : questions){
			
		}
		

		req.setAttribute("selectedMatiereId", selectedMatiereId);
		req.setAttribute("matieres", matieres);
		req.setAttribute("questions", selectedQuestions);
		
		getServletContext().getRequestDispatcher(urlQuestions).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	

}
