package mz.co.basse.cattlecore.utils;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtilTest {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cattletest");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
