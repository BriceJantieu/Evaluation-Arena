package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseSession;

/**
 * This is the object class that relates to the Session table.
 * Any customizations belong here.
 */
public class Session extends BaseSession {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Session () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Session (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public Session (
		java.lang.Integer _id,
		com.ingesup.evaluationArena.hibernate.beans.Examen _examen,
		com.ingesup.evaluationArena.hibernate.beans.SessionState _sessionState,
		java.lang.String _name,
		java.lang.Integer _duration,
		java.util.Date _createDate) {

		super (
			_id,
			_examen,
			_sessionState,
			_name,
			_duration,
			_createDate);
	}

/*[CONSTRUCTOR MARKER END]*/
}