package com.ingesup.evaluationArena.hibernate.beans.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 */
public class BasePromoUtilisateurPK implements Serializable {

	private int hashCode = Integer.MIN_VALUE;

	private com.ingesup.evaluationArena.hibernate.beans.Promo _promo;
	private com.ingesup.evaluationArena.hibernate.beans.PromoUtilisateurState _promoUtilisateurState;
	private com.ingesup.evaluationArena.hibernate.beans.Utilisateur _utilisateur;

	public BasePromoUtilisateurPK () {}
	
	public BasePromoUtilisateurPK (
		com.ingesup.evaluationArena.hibernate.beans.Promo _promo,
		com.ingesup.evaluationArena.hibernate.beans.PromoUtilisateurState _promoUtilisateurState,
		com.ingesup.evaluationArena.hibernate.beans.Utilisateur _utilisateur) {

		this.setPromo(_promo);
		this.setPromoUtilisateurState(_promoUtilisateurState);
		this.setUtilisateur(_utilisateur);
	}


	public com.ingesup.evaluationArena.hibernate.beans.Promo getPromo () {
		return _promo;
	}

	public void setPromo (com.ingesup.evaluationArena.hibernate.beans.Promo _promo) {
		hashCode = Integer.MIN_VALUE;
		this._promo = _promo;
	}

	public com.ingesup.evaluationArena.hibernate.beans.PromoUtilisateurState getPromoUtilisateurState () {
		return _promoUtilisateurState;
	}

	public void setPromoUtilisateurState (com.ingesup.evaluationArena.hibernate.beans.PromoUtilisateurState _promoUtilisateurState) {
		hashCode = Integer.MIN_VALUE;
		this._promoUtilisateurState = _promoUtilisateurState;
	}

	public com.ingesup.evaluationArena.hibernate.beans.Utilisateur getUtilisateur () {
		return _utilisateur;
	}

	public void setUtilisateur (com.ingesup.evaluationArena.hibernate.beans.Utilisateur _utilisateur) {
		hashCode = Integer.MIN_VALUE;
		this._utilisateur = _utilisateur;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ingesup.evaluationArena.hibernate.beans.PromoUtilisateurPK)) return false;
		else {
			com.ingesup.evaluationArena.hibernate.beans.PromoUtilisateurPK mObj = (com.ingesup.evaluationArena.hibernate.beans.PromoUtilisateurPK) obj;
			if (null != this.getPromo() && null != mObj.getPromo()) {
				if (!this.getPromo().equals(mObj.getPromo())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getPromoUtilisateurState() && null != mObj.getPromoUtilisateurState()) {
				if (!this.getPromoUtilisateurState().equals(mObj.getPromoUtilisateurState())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getUtilisateur() && null != mObj.getUtilisateur()) {
				if (!this.getUtilisateur().equals(mObj.getUtilisateur())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuffer sb = new StringBuffer();
			if (null != this.getPromo()) {
				sb.append(this.getPromo().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getPromoUtilisateurState()) {
				sb.append(this.getPromoUtilisateurState().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getUtilisateur()) {
				sb.append(this.getUtilisateur().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}

}