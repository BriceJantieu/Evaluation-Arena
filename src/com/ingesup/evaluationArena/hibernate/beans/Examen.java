package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseExamen;

/**
 * This is the object class that relates to the Examen table.
 * Any customizations belong here.
 */
public class Examen extends BaseExamen {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Examen () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Examen (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Examen (
		java.lang.Integer _id,
		com.ingesup.evaluationArena.hibernate.beans.Utilisateur _teacher,
		com.ingesup.evaluationArena.hibernate.beans.Matiere _matiere,
		java.lang.String _name) {

		super (
			_id,
			_teacher,
			_matiere,
			_name);
	}
/*[CONSTRUCTOR MARKER END]*/
}