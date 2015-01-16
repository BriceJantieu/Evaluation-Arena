package com.ingesup.evaluationArena.servlets;

public class Question {

	private int id;
	private String content;
	private Matiere matiere;	
	
	public Question(int id, String content, Matiere matiere) {
		super();
		this.id = id;
		this.content = content;
		this.matiere = matiere;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	
	
	
}
