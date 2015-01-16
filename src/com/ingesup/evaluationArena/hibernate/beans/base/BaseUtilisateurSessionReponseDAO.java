package com.ingesup.evaluationArena.hibernate.beans.base;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Session;
import com.ingesup.evaluationArena.hibernate.beans.dao.UtilisateurSessionReponseDAO;

/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 *
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseUtilisateurSessionReponseDAO extends com.ingesup.evaluationArena.hibernate.beans.dao._RootDAO {

	public static UtilisateurSessionReponseDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static UtilisateurSessionReponseDAO getInstance () {
		if (null == instance) instance = new UtilisateurSessionReponseDAO();
		return instance;
	}

	/**
	 * com.ingesup.evaluationArena.hibernate.beans.dao._RootDAO _RootDAO.getReferenceClass()
	 */
	public Class getReferenceClass () {
		return com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse.class;
	}
	
	public com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse load(com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse key)
		throws net.sf.hibernate.HibernateException {
		return (com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse) load(getReferenceClass(), key);
	}

	public com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse load(com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse key, Session s)
		throws net.sf.hibernate.HibernateException {
		return (com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse) load(getReferenceClass(), key, s);
	}

	public com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse loadInitialize(com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse key, Session s) 
			throws net.sf.hibernate.HibernateException { 
		com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param utilisateurSessionReponse a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse save(com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse utilisateurSessionReponse)
		throws net.sf.hibernate.HibernateException {
		return (com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse) super.save(utilisateurSessionReponse);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param utilisateurSessionReponse a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse save(com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse utilisateurSessionReponse, Session s)
		throws net.sf.hibernate.HibernateException {
		return (com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse) super.save(utilisateurSessionReponse, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param utilisateurSessionReponse a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse utilisateurSessionReponse)
		throws net.sf.hibernate.HibernateException {
		super.saveOrUpdate(utilisateurSessionReponse);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param utilisateurSessionReponse a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse utilisateurSessionReponse, Session s)
		throws net.sf.hibernate.HibernateException {
		super.saveOrUpdate(utilisateurSessionReponse, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param utilisateurSessionReponse a transient instance containing updated state
	 */
	public void update(com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse utilisateurSessionReponse) 
		throws net.sf.hibernate.HibernateException {
		super.update(utilisateurSessionReponse);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param utilisateurSessionReponse a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse utilisateurSessionReponse, Session s)
		throws net.sf.hibernate.HibernateException {
		super.update(utilisateurSessionReponse, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param utilisateurSessionReponse the instance to be removed
	 */
	public void delete(com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse utilisateurSessionReponse)
		throws net.sf.hibernate.HibernateException {
		super.delete(utilisateurSessionReponse);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param utilisateurSessionReponse the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse utilisateurSessionReponse, Session s)
		throws net.sf.hibernate.HibernateException {
		super.delete(utilisateurSessionReponse, s);
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
	public void refresh (com.ingesup.evaluationArena.hibernate.beans.UtilisateurSessionReponse utilisateurSessionReponse, Session s)
		throws net.sf.hibernate.HibernateException {
		super.refresh(utilisateurSessionReponse, s);
	}

    public String getDefaultOrderProperty () {
		return null;
    }

}