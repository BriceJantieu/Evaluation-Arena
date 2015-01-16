package com.ingesup.evaluationArena.hibernate.beans.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the Reponse table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Reponse"
 */
public abstract class BaseReponse  implements Serializable {

	public static String PROP_NAME = "Name";
	public static String PROP_CATEGORIE = "Categorie";
	public static String PROP_ID = "Id";
	public static String PROP_CONTENT = "Content";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _id;

	// fields
	private java.lang.String _name;
	private java.lang.String _content;

	// many to one
	private com.ingesup.evaluationArena.hibernate.beans.Categorie _categorie;

	// collections
	private java.util.Set _questionReponseSet;
	private java.util.Set _utilisateurSessionSet;


	// constructors
	public BaseReponse () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReponse (java.lang.Integer _id) {
		this.setId(_id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseReponse (
		java.lang.Integer _id,
		com.ingesup.evaluationArena.hibernate.beans.Categorie _categorie,
		java.lang.String _name,
		java.lang.String _content) {

		this.setId(_id);
		this.setCategorie(_categorie);
		this.setName(_name);
		this.setContent(_content);
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
	 * Return the value associated with the column: Name
	 */
	public java.lang.String getName () {
		return _name;
	}

	/**
	 * Set the value related to the column: Name
	 * @param _name the Name value
	 */
	public void setName (java.lang.String _name) {
		this._name = _name;
	}


	/**
	 * Return the value associated with the column: Content
	 */
	public java.lang.String getContent () {
		return _content;
	}

	/**
	 * Set the value related to the column: Content
	 * @param _content the Content value
	 */
	public void setContent (java.lang.String _content) {
		this._content = _content;
	}


	/**
     * @hibernate.property
     *  column=Categorie_ID
	 * not-null=true
	 */
	public com.ingesup.evaluationArena.hibernate.beans.Categorie getCategorie () {
		return this._categorie;
	}

	/**
	 * Set the value related to the column: Categorie_ID
	 * @param _categorie the Categorie_ID value
	 */
	public void setCategorie (com.ingesup.evaluationArena.hibernate.beans.Categorie _categorie) {
		this._categorie = _categorie;
	}


	/**
	 * Return the value associated with the column: QuestionReponseSet
	 */
	public java.util.Set getQuestionReponseSet () {
		return this._questionReponseSet;
	}

	/**
	 * Set the value related to the column: QuestionReponseSet
	 * @param _questionReponseSet the QuestionReponseSet value
	 */
	public void setQuestionReponseSet (java.util.Set _questionReponseSet) {
		this._questionReponseSet = _questionReponseSet;
	}
	
	public void addToQuestionReponseSet (Object obj) {
		if (null == this._questionReponseSet) this._questionReponseSet = new java.util.HashSet();
		this._questionReponseSet.add(obj);
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



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ingesup.evaluationArena.hibernate.beans.base.BaseReponse)) return false;
		else {
			com.ingesup.evaluationArena.hibernate.beans.base.BaseReponse mObj = (com.ingesup.evaluationArena.hibernate.beans.base.BaseReponse) obj;
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