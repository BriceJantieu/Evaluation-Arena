package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseExamenUtilisateur;

/**
 * This is the object class that relates to the Examen_Utilisateur table.
 * Any customizations belong here.
 */
public class ExamenUtilisateur extends BaseExamenUtilisateur {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ExamenUtilisateur () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ExamenUtilisateur (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public ExamenUtilisateur (
		java.lang.Integer _id,
		com.ingesup.evaluationArena.hibernate.beans.Examen _examen,
		com.ingesup.evaluationArena.hibernate.beans.Utilisateur _utilisateur,
		boolean _isCompleted) {

		super (
			_id,
			_examen,
			_utilisateur,
			_isCompleted);
	}

/*[CONSTRUCTOR MARKER END]*/
}