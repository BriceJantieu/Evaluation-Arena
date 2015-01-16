import java.util.List;
import java.util.Set;

import com.ingesup.evaluationArena.hibernate.beans.Utilisateur;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;



public class testUser {

	public static void main(String[] args) throws HibernateException {
		// récupération de la session
				Session s = HibernateUtil.currentSession();
				
				List<Utilisateur> lstFilms = s.find("from Utilisateur");
				for(Utilisateur f : lstFilms){
					
					
					
					System.out.println(f.getFirstName());
					
					
					
					
					
					
				}
				
				HibernateUtil.closeSession();
			}
}