package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BasePromo;

/**
 * This is the object class that relates to the Promo table.
 * Any customizations belong here.
 */
public class Promo extends BasePromo {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Promo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Promo (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Promo (
		java.lang.Integer _id,
		java.util.Date _creationDate,
		java.lang.String _libelle) {

		super (
			_id,
			_creationDate,
			_libelle);
	}

/*[CONSTRUCTOR MARKER END]*/
}