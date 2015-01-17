package com.ingesup.evaluationArena.servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import com.ingesup.evaluationArena.hibernate.beans.Categorie;
import com.ingesup.evaluationArena.tools.HibernateUtil;

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
		
		List<Categorie> categorie = null;
		try {
			categorie = HibernateUtil.currentSession().find("from Categorie");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("categories", categorie);
		
		getServletContext().getRequestDispatcher(urlCreateQuestion).forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String questionContent = req.getParameter("question");
		String matiereId = req.getParameter("categorie");
		String rightResponse = req.getParameter("rightResponse");
		String response1Content = req.getParameter("response1");
		String response2Content = req.getParameter("response2");
		String response3Content = req.getParameter("response3");
		String response4Content = req.getParameter("response4");
		
		System.out.println("Question créée.");
		
	}
}
