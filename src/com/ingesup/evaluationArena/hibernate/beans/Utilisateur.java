package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseUtilisateur;

/**
 * This is the object class that relates to the Utilisateur table.
 * Any customizations belong here.
 */
public class Utilisateur extends BaseUtilisateur {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Utilisateur () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Utilisateur (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Utilisateur (
		java.lang.Integer _id,
		java.lang.String _email,
		java.lang.String _password,
		java.lang.String _username,
		java.lang.String _firstName,
		java.util.Date _creationDate,
		java.lang.String _lastName,
		java.util.Date _birthDate) {

		super (
			_id,
			_email,
			_password,
			_username,
			_firstName,
			_creationDate,
			_lastName,
			_birthDate);
	}

/*[CONSTRUCTOR MARKER END]*/
}