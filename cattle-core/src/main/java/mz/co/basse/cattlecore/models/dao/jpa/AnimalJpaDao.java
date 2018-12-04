package mz.co.basse.cattlecore.models.dao.jpa;

import javax.persistence.EntityManager;

import mz.co.basse.cattlecore.models.Animal;
import mz.co.basse.cattlecore.models.dao.AnimalDao;
import mz.co.basse.cattlecore.utils.JPAUtil;

public class AnimalJpaDao implements AnimalDao {
	
	private EntityManager entityManager = (EntityManager) new JPAUtil().getEntityManager();


	public void create(Animal animal) {
		entityManager.getTransaction().begin();
		entityManager.persist(animal);
		entityManager.getTransaction().commit();

	}

}
