package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseUtilisateurSession;

/**
 * This is the object class that relates to the Utilisateur_Session table.
 * Any customizations belong here.
 */
public class UtilisateurSession extends BaseUtilisateurSession {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UtilisateurSession () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UtilisateurSession (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public UtilisateurSession (
		java.lang.Integer _id,
		com.ingesup.evaluationArena.hibernate.beans.Session _session,
		com.ingesup.evaluationArena.hibernate.beans.Utilisateur _utilisateur,
		java.util.Date _endDate,
		java.util.Date _startDate) {

		super (
			_id,
			_session,
			_utilisateur,
			_endDate,
			_startDate);
	}

/*[CONSTRUCTOR MARKER END]*/
}