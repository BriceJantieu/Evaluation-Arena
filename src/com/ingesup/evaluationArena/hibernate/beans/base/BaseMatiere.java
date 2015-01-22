package com.ingesup.evaluationArena.hibernate.beans.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an object that contains data related to the Matiere table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="Matiere"
 */
public abstract class BaseMatiere  implements Serializable {

	public static String PROP_ID = "Id";
	public static String PROP_LIBELLE = "Libelle";


	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private java.lang.Integer _id;

	// fields
	private java.lang.String _libelle;

	// collections
	private java.util.Set _examenSet;


	// constructors
	public BaseMatiere () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMatiere (java.lang.Integer _id) {
		this.setId(_id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMatiere (
		java.lang.Integer _id,
		java.lang.String _libelle) {

		this.setId(_id);
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
	 * Return the value associated with the column: ExamenSet
	 */
	public java.util.Set getExamenSet () {
		return this._examenSet;
	}

	/**
	 * Set the value related to the column: ExamenSet
	 * @param _examenSet the ExamenSet value
	 */
	public void setExamenSet (java.util.Set _examenSet) {
		this._examenSet = _examenSet;
	}
	
	public void addToExamenSet (Object obj) {
		if (null == this._examenSet) this._examenSet = new java.util.HashSet();
		this._examenSet.add(obj);
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ingesup.evaluationArena.hibernate.beans.base.BaseMatiere)) return false;
		else {
			com.ingesup.evaluationArena.hibernate.beans.base.BaseMatiere mObj = (com.ingesup.evaluationArena.hibernate.beans.base.BaseMatiere) obj;
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