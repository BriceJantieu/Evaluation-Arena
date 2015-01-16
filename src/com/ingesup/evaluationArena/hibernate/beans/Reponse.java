package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseReponse;

/**
 * This is the object class that relates to the Reponse table.
 * Any customizations belong here.
 */
public class Reponse extends BaseReponse {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Reponse () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Reponse (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Reponse (
		java.lang.Integer _id,
		com.ingesup.evaluationArena.hibernate.beans.Categorie _categorie,
		java.lang.String _name,
		java.lang.String _content) {

		super (
			_id,
			_categorie,
			_name,
			_content);
	}

/*[CONSTRUCTOR MARKER END]*/
}