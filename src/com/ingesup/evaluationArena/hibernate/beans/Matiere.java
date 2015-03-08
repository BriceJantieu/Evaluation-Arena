package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseMatiere;

/**
 * This is the object class that relates to the Matiere table.
 * Any customizations belong here.
 */
public class Matiere extends BaseMatiere {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Matiere () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Matiere (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Matiere (
		java.lang.Integer _id,
		java.lang.String _libelle) {

		super (
			_id,
			_libelle);
	}

/*[CONSTRUCTOR MARKER END]*/
}