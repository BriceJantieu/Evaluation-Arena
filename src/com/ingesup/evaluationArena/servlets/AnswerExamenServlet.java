package com.ingesup.evaluationArena.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Transaction;

import com.ingesup.evaluationArena.hibernate.beans.Examen;
import com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion;
import com.ingesup.evaluationArena.hibernate.beans.ExamenUtilisateur;
import com.ingesup.evaluationArena.hibernate.beans.Question;
import com.ingesup.evaluationArena.hibernate.beans.Reponse;
import com.ingesup.evaluationArena.hibernate.beans.Utilisateur;
import com.ingesup.evaluationArena.hibernate.beans.UtilisateurQuestionReponse;
import com.ingesup.evaluationArena.tools.AuthentificateHttpServlet;
import com.ingesup.evaluationArena.tools.HibernateUtil;

public class AnswerExamenServlet extends AuthentificateHttpServlet {

	private String urlAnswerExamen;
	private String urlExamens;
	
	private String examenId;
	
	private List<Question> examenQuestions;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		urlAnswerExamen = getInitParameter("urlAnswerExamen");
		urlExamens = getInitParameter("urlExamens");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userID");
		
		Enumeration<String> paramsName = req.getParameterNames();
		
		int correctQuestionCount = 0;
		
		while(paramsName.hasMoreElements()){
			String paramName = paramsName.nextElement();
			
			if (paramName.contains("response")) {
			
				String reponseId = req.getParameter(paramName);
				String questionId = req.getParameter("question" + reponseId);
				
				UtilisateurQuestionReponse uqr = new UtilisateurQuestionReponse();
				Question q = new Question();
				Utilisateur u = new Utilisateur();
				Reponse r = new Reponse();
				
				if(responseIsCorrect(reponseId, questionId))
					correctQuestionCount ++;
			
				q.setId(Integer.valueOf(questionId));
				r.setId(Integer.valueOf(reponseId));
				u.setId(Integer.valueOf(userId));
				
				uqr.setQuestion(q);
				uqr.setUtilisateur(u);
				uqr.setReponse(r);
				
				try {
					Transaction t = HibernateUtil.currentSession().beginTransaction();
					HibernateUtil.currentSession().save(uqr);
					t.commit();
					
				} catch (HibernateException ignored) {}
			}
		}
		
		notifyExamenCompleted(userId, correctQuestionCount);
		
		resp.sendRedirect(urlExamens);
	}

	private void notifyExamenCompleted(String userId, int correctQuestionCount){
		ExamenUtilisateur eu = null;
		int result = (correctQuestionCount * 20) / examenQuestions.size();
		
		try {
			List<ExamenUtilisateur> examenUtilisateurs = HibernateUtil.currentSession().find("from ExamenUtilisateur where Utilisateur_ID = " + userId + " and Examen_ID = " + examenId);
			eu = examenUtilisateurs.get(0);
			eu.setIsCompleted(true);
			eu.setResult(result);
			
			Transaction t = HibernateUtil.currentSession().beginTransaction();
			HibernateUtil.currentSession().save(eu);
			t.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	private boolean responseIsCorrect(String responseId, String questionId){	
		for(Question q : examenQuestions){
			int intQuestionId = Integer.valueOf(questionId);
			if(q.getId() == intQuestionId){
				for(Object o : q.getReponseSet()){
					Reponse r = (Reponse) o;
					int intResponseId = Integer.valueOf(responseId);
					if(r.isIsValid() && r.getId() == intResponseId)
						return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public void doGetAdmin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

	@Override
	public void doGetTeacher(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

	@Override
	public void doGetStudent(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		examenId = (String) req.getParameter("examenId");
		
		HttpSession session = req.getSession();
		String userID = session.getAttribute("userID").toString();
		
		Examen examen = null;
		List<ExamenQuestion> examenQ = null;
		examenQuestions = new ArrayList<>();
		
		try {
			examen = retrieveExamen(examenId);
			examenQ = HibernateUtil.currentSession().find("from ExamenQuestion where Examen_ID = " + examenId);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		if (examenQ != null) {
			for (ExamenQuestion eq : examenQ) {
				examenQuestions.add(eq.getQuestion());
			}
		}
		
		req.setAttribute("examen", examen);
		req.setAttribute("questions", examenQuestions);

		getServletContext().getRequestDispatcher(urlAnswerExamen).forward(req, resp);
	}
	
	private Examen retrieveExamen(String examenId) throws HibernateException{
		List<Examen> examens = HibernateUtil.currentSession().find("from Examen where ID = " + examenId);
		
		if(examens != null && !examens.isEmpty())
			return examens.get(0);
		
		return null;
	}

}
