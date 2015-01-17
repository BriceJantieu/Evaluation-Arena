package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseQuestionMatierePK;

public class QuestionMatierePK extends BaseQuestionMatierePK {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public QuestionMatierePK () {}
	
	public QuestionMatierePK (
		com.ingesup.evaluationArena.hibernate.beans.Question _question,
		com.ingesup.evaluationArena.hibernate.beans.QuestionDifficulty _questionDifficulty,
		com.ingesup.evaluationArena.hibernate.beans.Matiere _matiere) {

		super (
		_question,
		_questionDifficulty,
		_matiere);
	}
/*[CONSTRUCTOR MARKER END]*/
}