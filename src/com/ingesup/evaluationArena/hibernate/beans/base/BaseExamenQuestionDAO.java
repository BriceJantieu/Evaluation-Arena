package com.ingesup.evaluationArena.hibernate.beans.base;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Session;
import com.ingesup.evaluationArena.hibernate.beans.dao.ExamenQuestionDAO;

/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseExamenQuestionDAO extends com.ingesup.evaluationArena.hibernate.beans.dao._RootDAO {

	public static ExamenQuestionDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static ExamenQuestionDAO getInstance () {
		if (null == instance) instance = new ExamenQuestionDAO();
		return instance;
	}

	/**
	 * com.ingesup.evaluationArena.hibernate.beans.dao._RootDAO _RootDAO.getReferenceClass()
	 */
	public Class getReferenceClass () {
		return com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion.class;
	}
	
	public com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion load(com.ingesup.evaluationArena.hibernate.beans.ExamenQuestionPK key)
		throws net.sf.hibernate.HibernateException {
		return (com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion) load(getReferenceClass(), key);
	}

	public com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion load(com.ingesup.evaluationArena.hibernate.beans.ExamenQuestionPK key, Session s)
		throws net.sf.hibernate.HibernateException {
		return (com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion) load(getReferenceClass(), key, s);
	}

	public com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion loadInitialize(com.ingesup.evaluationArena.hibernate.beans.ExamenQuestionPK key, Session s) 
			throws net.sf.hibernate.HibernateException { 
		com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param examenQuestion a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public com.ingesup.evaluationArena.hibernate.beans.ExamenQuestionPK save(com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion examenQuestion)
		throws net.sf.hibernate.HibernateException {
		return (com.ingesup.evaluationArena.hibernate.beans.ExamenQuestionPK) super.save(examenQuestion);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param examenQuestion a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public com.ingesup.evaluationArena.hibernate.beans.ExamenQuestionPK save(com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion examenQuestion, Session s)
		throws net.sf.hibernate.HibernateException {
		return (com.ingesup.evaluationArena.hibernate.beans.ExamenQuestionPK) super.save(examenQuestion, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param examenQuestion a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion examenQuestion)
		throws net.sf.hibernate.HibernateException {
		super.saveOrUpdate(examenQuestion);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param examenQuestion a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion examenQuestion, Session s)
		throws net.sf.hibernate.HibernateException {
		super.saveOrUpdate(examenQuestion, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param examenQuestion a transient instance containing updated state
	 */
	public void update(com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion examenQuestion) 
		throws net.sf.hibernate.HibernateException {
		super.update(examenQuestion);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param examenQuestion a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion examenQuestion, Session s)
		throws net.sf.hibernate.HibernateException {
		super.update(examenQuestion, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(com.ingesup.evaluationArena.hibernate.beans.ExamenQuestionPK id)
		throws net.sf.hibernate.HibernateException {
		super.delete(load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param id the instance ID to be removed
	 * @param s the Session
	 */
	public void delete(com.ingesup.evaluationArena.hibernate.beans.ExamenQuestionPK id, Session s)
		throws net.sf.hibernate.HibernateException {
		super.delete(load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param examenQuestion the instance to be removed
	 */
	public void delete(com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion examenQuestion)
		throws net.sf.hibernate.HibernateException {
		super.delete(examenQuestion);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param examenQuestion the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion examenQuestion, Session s)
		throws net.sf.hibernate.HibernateException {
		super.delete(examenQuestion, s);
	}
	
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (com.ingesup.evaluationArena.hibernate.beans.ExamenQuestion examenQuestion, Session s)
		throws net.sf.hibernate.HibernateException {
		super.refresh(examenQuestion, s);
	}

    public String getDefaultOrderProperty () {
		return null;
    }

}