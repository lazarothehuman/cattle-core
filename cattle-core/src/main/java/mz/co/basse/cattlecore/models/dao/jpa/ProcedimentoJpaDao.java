package mz.co.basse.cattlecore.models.dao.jpa;

import javax.persistence.EntityManager;

import mz.co.basse.cattlecore.models.Procedimento;
import mz.co.basse.cattlecore.models.dao.ProcedimentoDao;
import mz.co.basse.cattlecore.utils.JPAUtil;

public class ProcedimentoJpaDao implements ProcedimentoDao {
	private EntityManager entityManager = (EntityManager) new JPAUtil().getEntityManager();

	public void create(Procedimento procedimento) {
		entityManager.getTransaction().begin();
		entityManager.persist(procedimento);
		entityManager.getTransaction().commit();
	}

}
