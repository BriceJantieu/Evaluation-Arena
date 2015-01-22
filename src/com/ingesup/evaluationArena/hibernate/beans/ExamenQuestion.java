package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseExamenQuestion;

/**
 * This is the object class that relates to the Examen_Question table.
 * Any customizations belong here.
 */
public class ExamenQuestion extends BaseExamenQuestion {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ExamenQuestion () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ExamenQuestion (com.ingesup.evaluationArena.hibernate.beans.ExamenQuestionPK _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public ExamenQuestion (
		com.ingesup.evaluationArena.hibernate.beans.ExamenQuestionPK _id,
		java.lang.Integer _weight,
		java.lang.Integer _order) {

		super (
			_id,
			_weight,
			_order);
	}

/*[CONSTRUCTOR MARKER END]*/
}