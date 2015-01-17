package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BasePromoUtilisateur;

/**
 * This is the object class that relates to the Promo_Utilisateur table.
 * Any customizations belong here.
 */
public class PromoUtilisateur extends BasePromoUtilisateur {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PromoUtilisateur () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PromoUtilisateur (com.ingesup.evaluationArena.hibernate.beans.PromoUtilisateurPK _id) {
		super(_id);
	}

	/**
	 * Constructor for required fields
	 */
	public PromoUtilisateur (
		com.ingesup.evaluationArena.hibernate.beans.PromoUtilisateurPK _id,
		java.util.Date _creationDate) {

		super (
			_id,
			_creationDate);
	}

/*[CONSTRUCTOR MARKER END]*/
}