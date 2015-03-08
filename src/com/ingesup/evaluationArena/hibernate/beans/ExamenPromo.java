package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseExamenPromo;

/**
 * This is the object class that relates to the Examen_Promo table.
 * Any customizations belong here.
 */
public class ExamenPromo extends BaseExamenPromo {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ExamenPromo () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ExamenPromo (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public ExamenPromo (
		java.lang.Integer _id,
		com.ingesup.evaluationArena.hibernate.beans.Promo _promo,
		com.ingesup.evaluationArena.hibernate.beans.Examen _examen) {

		super (
			_id,
			_promo,
			_examen);
	}

/*[CONSTRUCTOR MARKER END]*/
}