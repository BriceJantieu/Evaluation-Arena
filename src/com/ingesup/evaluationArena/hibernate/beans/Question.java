package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseQuestion;

/**
 * This is the object class that relates to the Question table.
 * Any customizations belong here.
 */
public class Question extends BaseQuestion {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Question () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Question (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Question (
		java.lang.Integer _id,
		com.ingesup.evaluationArena.hibernate.beans.Utilisateur _utilisateur,
		com.ingesup.evaluationArena.hibernate.beans.Categorie _categorie,
		java.lang.String _name,
		java.lang.String _lastModificationBy,
		java.lang.String _content,
		java.util.Date _createDate) {

		super (
			_id,
			_utilisateur,
			_categorie,
			_name,
			_lastModificationBy,
			_content,
			_createDate);
	}

/*[CONSTRUCTOR MARKER END]*/
}