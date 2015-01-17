package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BasePromoSessionPK;

public class PromoSessionPK extends BasePromoSessionPK {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PromoSessionPK () {}
	
	public PromoSessionPK (
		com.ingesup.evaluationArena.hibernate.beans.Session _session,
		com.ingesup.evaluationArena.hibernate.beans.Promo _promo) {

		super (
		_session,
		_promo);
	}
/*[CONSTRUCTOR MARKER END]*/
}