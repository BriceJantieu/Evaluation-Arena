package com.ingesup.evaluationArena.servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.ingesup.evaluationArena.hibernate.beans.Categorie;
import com.ingesup.evaluationArena.hibernate.beans.Question;
import com.ingesup.evaluationArena.hibernate.beans.Reponse;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class CreateQuestionServlet extends HttpServlet {

	private String urlCreateQuestion;
	
	private List<Categorie> categories;
	
	@Override
	public void init() throws ServletException {
		super.init();

		urlCreateQuestion = getInitParameter("urlCreateQuestion");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			categories = HibernateUtil.currentSession().find("from Categorie");
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("categories", categories);
		
		getServletContext().getRequestDispatcher(urlCreateQuestion).forward(request, response);
		
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
}
