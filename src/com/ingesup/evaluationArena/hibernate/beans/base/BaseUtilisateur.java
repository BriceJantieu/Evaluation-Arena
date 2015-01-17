package com.ingesup.evaluationArena.hibernate.beans.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the Utilisateur table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Utilisateur"
 */
public abstract class BaseUtilisateur  implements Serializable {

	public static String PROP_EMAIL = "Email";
	public static String PROP_USERNAME = "Username";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_FIRST_NAME = "FirstName";
	public static String PROP_ID = "Id";
	public static String PROP_CREATION_DATE = "CreationDate";
	public static String PROP_LAST_NAME = "LastName";
	public static String PROP_BIRTH_DATE = "BirthDate";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _id;

	// fields
	private java.lang.String _email;
	private java.lang.String _password;
	private java.lang.String _username;
	private java.lang.String _firstName;
	private java.util.Date _creationDate;
	private java.lang.String _lastName;
	private java.util.Date _birthDate;

	// collections
	private java.util.Set _promoUtilisateurSet;
	private java.util.Set _utilisateurSessionSet;
	private java.util.Set _utilisateurRoleSet;


	// constructors
	public BaseUtilisateur () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUtilisateur (java.lang.Integer _id) {
		this.setId(_id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUtilisateur (
		java.lang.Integer _id,
		java.lang.String _email,
		java.lang.String _password,
		java.lang.String _username,
		java.lang.String _firstName,
		java.util.Date _creationDate,
		java.lang.String _lastName,
		java.util.Date _birthDate) {

		this.setId(_id);
		this.setEmail(_email);
		this.setPassword(_password);
		this.setUsername(_username);
		this.setFirstName(_firstName);
		this.setCreationDate(_creationDate);
		this.setLastName(_lastName);
		this.setBirthDate(_birthDate);
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
	 * Return the value associated with the column: Email
	 */
	public java.lang.String getEmail () {
		return _email;
	}

	/**
	 * Set the value related to the column: Email
	 * @param _email the Email value
	 */
	public void setEmail (java.lang.String _email) {
		this._email = _email;
	}


	/**
	 * Return the value associated with the column: Password
	 */
	public java.lang.String getPassword () {
		return _password;
	}

	/**
	 * Set the value related to the column: Password
	 * @param _password the Password value
	 */
	public void setPassword (java.lang.String _password) {
		this._password = _password;
	}


	/**
	 * Return the value associated with the column: Username
	 */
	public java.lang.String getUsername () {
		return _username;
	}

	/**
	 * Set the value related to the column: Username
	 * @param _username the Username value
	 */
	public void setUsername (java.lang.String _username) {
		this._username = _username;
	}


	/**
	 * Return the value associated with the column: FirstName
	 */
	public java.lang.String getFirstName () {
		return _firstName;
	}

	/**
	 * Set the value related to the column: FirstName
	 * @param _firstName the FirstName value
	 */
	public void setFirstName (java.lang.String _firstName) {
		this._firstName = _firstName;
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
	 * Return the value associated with the column: LastName
	 */
	public java.lang.String getLastName () {
		return _lastName;
	}

	/**
	 * Set the value related to the column: LastName
	 * @param _lastName the LastName value
	 */
	public void setLastName (java.lang.String _lastName) {
		this._lastName = _lastName;
	}


	/**
	 * Return the value associated with the column: BirthDate
	 */
	public java.util.Date getBirthDate () {
		return _birthDate;
	}

	/**
	 * Set the value related to the column: BirthDate
	 * @param _birthDate the BirthDate value
	 */
	public void setBirthDate (java.util.Date _birthDate) {
		this._birthDate = _birthDate;
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
	 * Return the value associated with the column: UtilisateurSessionSet
	 */
	public java.util.Set getUtilisateurSessionSet () {
		return this._utilisateurSessionSet;
	}

	/**
	 * Set the value related to the column: UtilisateurSessionSet
	 * @param _utilisateurSessionSet the UtilisateurSessionSet value
	 */
	public void setUtilisateurSessionSet (java.util.Set _utilisateurSessionSet) {
		this._utilisateurSessionSet = _utilisateurSessionSet;
	}
	
	public void addToUtilisateurSessionSet (Object obj) {
		if (null == this._utilisateurSessionSet) this._utilisateurSessionSet = new java.util.HashSet();
		this._utilisateurSessionSet.add(obj);
	}



	/**
	 * Return the value associated with the column: UtilisateurRoleSet
	 */
	public java.util.Set getUtilisateurRoleSet () {
		return this._utilisateurRoleSet;
	}

	/**
	 * Set the value related to the column: UtilisateurRoleSet
	 * @param _utilisateurRoleSet the UtilisateurRoleSet value
	 */
	public void setUtilisateurRoleSet (java.util.Set _utilisateurRoleSet) {
		this._utilisateurRoleSet = _utilisateurRoleSet;
	}
	
	public void addToUtilisateurRoleSet (Object obj) {
		if (null == this._utilisateurRoleSet) this._utilisateurRoleSet = new java.util.HashSet();
		this._utilisateurRoleSet.add(obj);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ingesup.evaluationArena.hibernate.beans.base.BaseUtilisateur)) return false;
		else {
			com.ingesup.evaluationArena.hibernate.beans.base.BaseUtilisateur mObj = (com.ingesup.evaluationArena.hibernate.beans.base.BaseUtilisateur) obj;
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