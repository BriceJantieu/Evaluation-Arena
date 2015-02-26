package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseCategorie;

/**
 * This is the object class that relates to the Categorie table.
 * Any customizations belong here.
 */
public class Categorie extends BaseCategorie {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Categorie () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Categorie (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Categorie (
		java.lang.Integer _id,
		com.ingesup.evaluationArena.hibernate.beans.Matiere _matiere,
		java.lang.String _name) {

		super (
			_id,
			_matiere,
			_name);
	}
/*[CONSTRUCTOR MARKER END]*/
}