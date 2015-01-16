package com.ingesup.evaluationArena.hibernate.beans;

import com.ingesup.evaluationArena.hibernate.beans.base.BaseUtilisateurRolePK;

public class UtilisateurRolePK extends BaseUtilisateurRolePK {

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UtilisateurRolePK () {}
	
	public UtilisateurRolePK (
		com.ingesup.evaluationArena.hibernate.beans.Role _role,
		com.ingesup.evaluationArena.hibernate.beans.Utilisateur _utilisateur) {

		super (
		_role,
		_utilisateur);
	}
/*[CONSTRUCTOR MARKER END]*/
}