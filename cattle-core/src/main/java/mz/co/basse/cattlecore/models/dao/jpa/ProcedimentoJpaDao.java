package mz.co.basse.cattlecore.models.dao.jpa;

import java.util.List;

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

	public List<Procedimento> find(String nome, String descricao, Boolean active) {
		// TODO Auto-generated method stub
		return null;
	}

}
