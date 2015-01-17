package com.ingesup.evaluationArena.hibernate.beans.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the Promo table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Promo"
 */
public abstract class BasePromo  implements Serializable {

	public static String PROP_ID = "Id";
	public static String PROP_CREATION_DATE = "CreationDate";
	public static String PROP_LIBELLE = "Libelle";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _id;

	// fields
	private java.util.Date _creationDate;
	private java.lang.String _libelle;

	// collections
	private java.util.Set _promoUtilisateurSet;
	private java.util.Set _promoSessionSet;


	// constructors
	public BasePromo () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePromo (java.lang.Integer _id) {
		this.setId(_id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePromo (
		java.lang.Integer _id,
		java.util.Date _creationDate,
		java.lang.String _libelle) {

		this.setId(_id);
		this.setCreationDate(_creationDate);
		this.setLibelle(_libelle);
		initialize();
	}

	protected void initialize () {}



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="vm"
     *  column="ID"
     */
	public java.lang.Integer getId () {
		return _id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param _id the new ID
	 */
	public void setId (java.lang.Integer _id) {
		this._id = _id;
		this.hashCode = Integer.MIN_VALUE;
	}


	/**
	 * Return the value associated with the column: CreationDate
	 */
	public java.util.Date getCreationDate () {
		return _creationDate;
	}

	/**
	 * Set the value related to the column: CreationDate
	 * @param _creationDate the CreationDate value
	 */
	public void setCreationDate (java.util.Date _creationDate) {
		this._creationDate = _creationDate;
	}


	/**
	 * Return the value associated with the column: Libelle
	 */
	public java.lang.String getLibelle () {
		return _libelle;
	}

	/**
	 * Set the value related to the column: Libelle
	 * @param _libelle the Libelle value
	 */
	public void setLibelle (java.lang.String _libelle) {
		this._libelle = _libelle;
	}


	/**
	 * Return the value associated with the column: PromoUtilisateurSet
	 */
	public java.util.Set getPromoUtilisateurSet () {
		return this._promoUtilisateurSet;
	}

	/**
	 * Set the value related to the column: PromoUtilisateurSet
	 * @param _promoUtilisateurSet the PromoUtilisateurSet value
	 */
	public void setPromoUtilisateurSet (java.util.Set _promoUtilisateurSet) {
		this._promoUtilisateurSet = _promoUtilisateurSet;
	}
	
	public void addToPromoUtilisateurSet (Object obj) {
		if (null == this._promoUtilisateurSet) this._promoUtilisateurSet = new java.util.HashSet();
		this._promoUtilisateurSet.add(obj);
	}



	/**
	 * Return the value associated with the column: PromoSessionSet
	 */
	public java.util.Set getPromoSessionSet () {
		return this._promoSessionSet;
	}

	/**
	 * Set the value related to the column: PromoSessionSet
	 * @param _promoSessionSet the PromoSessionSet value
	 */
	public void setPromoSessionSet (java.util.Set _promoSessionSet) {
		this._promoSessionSet = _promoSessionSet;
	}
	
	public void addToPromoSessionSet (Object obj) {
		if (null == this._promoSessionSet) this._promoSessionSet = new java.util.HashSet();
		this._promoSessionSet.add(obj);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ingesup.evaluationArena.hibernate.beans.base.BasePromo)) return false;
		else {
			com.ingesup.evaluationArena.hibernate.beans.base.BasePromo mObj = (com.ingesup.evaluationArena.hibernate.beans.base.BasePromo) obj;
			if (null == this.getId() || null == mObj.getId()) return false;
			else return (this.getId().equals(mObj.getId()));
		}
	}


	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}

}