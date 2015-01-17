package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseQuestionDifficulty;

/**
 * This is the object class that relates to the Question_Difficulty table.
 * Any customizations belong here.
 */
public class QuestionDifficulty extends BaseQuestionDifficulty {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public QuestionDifficulty () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public QuestionDifficulty (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public QuestionDifficulty (
		java.lang.Integer _id,
		java.lang.String _libelle) {

		super (
			_id,
			_libelle);
	}

/*[CONSTRUCTOR MARKER END]*/
}