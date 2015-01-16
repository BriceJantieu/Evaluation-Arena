package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BasePromoSession;

/**
 * This is the object class that relates to the Promo_Session table.
 * Any customizations belong here.
 */
public class PromoSession extends BasePromoSession {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PromoSession () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PromoSession (com.ingesup.evaluationArena.hibernate.beans.PromoSessionPK _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public PromoSession (
		com.ingesup.evaluationArena.hibernate.beans.PromoSessionPK _id,
		java.util.Date _sessionStartDate,
		java.util.Date _sessionEndDate) {

		super (
			_id,
			_sessionStartDate,
			_sessionEndDate);
	}

/*[CONSTRUCTOR MARKER END]*/
}