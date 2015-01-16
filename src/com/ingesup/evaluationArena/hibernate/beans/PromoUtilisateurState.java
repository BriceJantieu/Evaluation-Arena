package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BasePromoUtilisateurState;

/**
 * This is the object class that relates to the Promo_Utilisateur_State table.
 * Any customizations belong here.
 */
public class PromoUtilisateurState extends BasePromoUtilisateurState {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PromoUtilisateurState () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PromoUtilisateurState (java.lang.Integer _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public PromoUtilisateurState (
		java.lang.Integer _id,
		java.lang.String _libelle) {

		super (
			_id,
			_libelle);
	}

/*[CONSTRUCTOR MARKER END]*/
}