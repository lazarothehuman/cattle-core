package mz.co.basse.cattlecore.models.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mz.co.basse.cattlecore.models.Coral;
import mz.co.basse.cattlecore.models.dao.CoralDao;
import mz.co.basse.cattlecore.utils.JPAUtil;

public class CoralJpaDao implements CoralDao {

	private EntityManager entityManager = (EntityManager) new JPAUtil().getEntityManager();

	public void create(Coral coral) {
		entityManager.getTransaction().begin();
		entityManager.persist(coral);
		entityManager.getTransaction().commit();
	}

	public List<Coral> find(Boolean active) {
		TypedQuery<Coral> query = entityManager.createQuery("select coral from Coral coral where active = :active",
				Coral.class);
		query.setParameter("active", active);
		List<Coral> corals = query.getResultList();
		if (corals.isEmpty()) {
			return null;
		}
		return corals;
	}

}
