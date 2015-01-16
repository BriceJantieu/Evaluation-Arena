package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseUtilisateurSessionReponse;

/**
 * This is the object class that relates to the Utilisateur_Session_Reponse table.
 * Any customizations belong here.
 */
public class UtilisateurSessionReponse extends BaseUtilisateurSessionReponse {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UtilisateurSessionReponse () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UtilisateurSessionReponse (
		com.ingesup.evaluationArena.hibernate.beans.UtilisateurSession _utilisateurSession,
		com.ingesup.evaluationArena.hibernate.beans.Reponse _reponse) {

		super (
			_utilisateurSession,
			_reponse);
	}

/*[CONSTRUCTOR MARKER END]*/
}