package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseSessionState;

/**
 * This is the object class that relates to the Session_State table.
 * Any customizations belong here.
 */
public class SessionState extends BaseSessionState {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public SessionState () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public SessionState (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public SessionState (
		java.lang.Integer _id,
		java.lang.String _libelle) {

		super (
			_id,
			_libelle);
	}

/*[CONSTRUCTOR MARKER END]*/
}