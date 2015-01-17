package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseExamenQuestionPK;

public class ExamenQuestionPK extends BaseExamenQuestionPK {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ExamenQuestionPK () {}
	
	public ExamenQuestionPK (
		com.ingesup.evaluationArena.hibernate.beans.Examen _examen,
		com.ingesup.evaluationArena.hibernate.beans.Question _question) {

		super (
		_examen,
		_question);
	}
/*[CONSTRUCTOR MARKER END]*/
}