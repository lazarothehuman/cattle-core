package mz.co.basse.cattlecore.utils;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cattle");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
