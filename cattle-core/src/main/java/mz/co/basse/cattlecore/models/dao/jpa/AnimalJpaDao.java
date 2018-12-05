package mz.co.basse.cattlecore.models.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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


	public Animal find(String code) {
		TypedQuery<Animal> query = entityManager.createQuery(
				"select animal from Animal animal "
						+ "where animal.code = :code", Animal.class);
		query.setParameter("code", code);
		List<Animal> animal = query.getResultList();
		if (animal.isEmpty()) {
			return null;
		}
		return animal.get(0);
	}

}
