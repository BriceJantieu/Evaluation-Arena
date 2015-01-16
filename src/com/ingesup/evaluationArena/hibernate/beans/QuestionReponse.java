package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseQuestionReponse;

/**
 * This is the object class that relates to the Question_Reponse table.
 * Any customizations belong here.
 */
public class QuestionReponse extends BaseQuestionReponse {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public QuestionReponse () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public QuestionReponse (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public QuestionReponse (
		java.lang.Integer _id,
		com.ingesup.evaluationArena.hibernate.beans.Reponse _reponse,
		com.ingesup.evaluationArena.hibernate.beans.Question _question,
		java.lang.Integer _weight,
		java.lang.Integer _order,
		boolean _isGoodAnswer) {

		super (
			_id,
			_reponse,
			_question,
			_weight,
			_order,
			_isGoodAnswer);
	}

/*[CONSTRUCTOR MARKER END]*/
}