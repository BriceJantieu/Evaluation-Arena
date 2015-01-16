package com.ingesup.evaluationArena.servlets;

public class Matiere {

	private int id;
	private String name;
	
	public Matiere(){};
	
	public Matiere(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
}
