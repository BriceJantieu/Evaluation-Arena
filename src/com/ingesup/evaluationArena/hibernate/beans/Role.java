package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseRole;

/**
 * This is the object class that relates to the Role table.
 * Any customizations belong here.
 */
public class Role extends BaseRole {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Role () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Role (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Role (
		java.lang.Integer _id,
		java.lang.String _libelle) {

		super (
			_id,
			_libelle);
	}

/*[CONSTRUCTOR MARKER END]*/
}