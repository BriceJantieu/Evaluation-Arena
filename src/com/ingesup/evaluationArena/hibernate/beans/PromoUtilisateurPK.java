package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BasePromoUtilisateurPK;

public class PromoUtilisateurPK extends BasePromoUtilisateurPK {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PromoUtilisateurPK () {}
	
	public PromoUtilisateurPK (
		com.ingesup.evaluationArena.hibernate.beans.Promo _promo,
		com.ingesup.evaluationArena.hibernate.beans.PromoUtilisateurState _promoUtilisateurState,
		com.ingesup.evaluationArena.hibernate.beans.Utilisateur _utilisateur) {

		super (
		_promo,
		_promoUtilisateurState,
		_utilisateur);
	}
/*[CONSTRUCTOR MARKER END]*/
}