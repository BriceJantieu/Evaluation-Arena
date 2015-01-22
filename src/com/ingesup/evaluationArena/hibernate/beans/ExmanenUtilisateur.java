package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseExmanenUtilisateur;

/**
 * This is the object class that relates to the Exmanen_Utilisateur table.
 * Any customizations belong here.
 */
public class ExmanenUtilisateur extends BaseExmanenUtilisateur {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ExmanenUtilisateur () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ExmanenUtilisateur (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public ExmanenUtilisateur (
		java.lang.Integer _id,
		com.ingesup.evaluationArena.hibernate.beans.Examen _examen,
		com.ingesup.evaluationArena.hibernate.beans.Utilisateur _utilisateur) {

		super (
			_id,
			_examen,
			_utilisateur);
	}

/*[CONSTRUCTOR MARKER END]*/
}