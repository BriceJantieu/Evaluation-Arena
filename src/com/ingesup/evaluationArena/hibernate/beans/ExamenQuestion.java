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
	public ExamenQuestion (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public ExamenQuestion (
		java.lang.Integer _id,
		com.ingesup.evaluationArena.hibernate.beans.Examen _examen,
		com.ingesup.evaluationArena.hibernate.beans.Question _question,
		java.lang.Integer _questionOrder) {

		super (
			_id,
			_examen,
			_question,
			_questionOrder);
	}

/*[CONSTRUCTOR MARKER END]*/
}