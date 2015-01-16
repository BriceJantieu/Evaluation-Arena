package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseUtilisateurRole;

/**
 * This is the object class that relates to the Utilisateur_Role table.
 * Any customizations belong here.
 */
public class UtilisateurRole extends BaseUtilisateurRole {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UtilisateurRole () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UtilisateurRole (com.ingesup.evaluationArena.hibernate.beans.UtilisateurRolePK _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public UtilisateurRole (
		com.ingesup.evaluationArena.hibernate.beans.UtilisateurRolePK _id,
		java.lang.String _modifiedBy,
		java.util.Date _creationDate,
		java.util.Date _updateDate) {

		super (
			_id,
			_modifiedBy,
			_creationDate,
			_updateDate);
	}

/*[CONSTRUCTOR MARKER END]*/
}