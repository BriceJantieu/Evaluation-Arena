package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateQuestionServlet extends HttpServlet {

	private String urlCreateQuestion;
	
	@Override
	public void init() throws ServletException {
		super.init();

		urlCreateQuestion = getInitParameter("urlCreateQuestion");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Matiere> matieres = new ArrayList<Matiere>();
		Matiere matiere1 = new Matiere(1, "Matiere 1");

		Matiere matiere2 = new Matiere(2, "Matiere 2");

		Matiere matiere3 = new Matiere(3, "Matiere 3");

		Matiere matiere4 = new Matiere(4, "Matiere 4");
		
		matieres.add(matiere1);
		matieres.add(matiere2);
		matieres.add(matiere3);
		matieres.add(matiere4);
		
		request.setAttribute("matieres", matieres);
		
		getServletContext().getRequestDispatcher(urlCreateQuestion).forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String questionContent = req.getParameter("question");
		String matiereId = req.getParameter("matiere");
		String rightResponse = req.getParameter("rightResponse");
		String response1Content = req.getParameter("response1");
		String response2Content = req.getParameter("response2");
		String response3Content = req.getParameter("response3");
		String response4Content = req.getParameter("response4");
		
		System.out.println("Question créée.");
		
	}
}
