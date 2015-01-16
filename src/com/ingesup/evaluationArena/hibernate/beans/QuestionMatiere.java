package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseQuestionMatiere;

/**
 * This is the object class that relates to the Question_Matiere table.
 * Any customizations belong here.
 */
public class QuestionMatiere extends BaseQuestionMatiere {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public QuestionMatiere () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public QuestionMatiere (com.ingesup.evaluationArena.hibernate.beans.QuestionMatierePK _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public QuestionMatiere (
		com.ingesup.evaluationArena.hibernate.beans.QuestionMatierePK _id,
		java.util.Date _updatedDate) {

		super (
			_id,
			_updatedDate);
	}

/*[CONSTRUCTOR MARKER END]*/
}