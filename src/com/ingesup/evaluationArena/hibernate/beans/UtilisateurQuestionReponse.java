package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseUtilisateurQuestionReponse;

/**
 * This is the object class that relates to the Utilisateur_Question_Reponse table.
 * Any customizations belong here.
 */
public class UtilisateurQuestionReponse extends BaseUtilisateurQuestionReponse {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UtilisateurQuestionReponse () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UtilisateurQuestionReponse (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public UtilisateurQuestionReponse (
		java.lang.Integer _id,
		com.ingesup.evaluationArena.hibernate.beans.Reponse _reponse,
		com.ingesup.evaluationArena.hibernate.beans.Question _question,
		com.ingesup.evaluationArena.hibernate.beans.Utilisateur _utilisateur) {

		super (
			_id,
			_reponse,
			_question,
			_utilisateur);
	}

/*[CONSTRUCTOR MARKER END]*/
}