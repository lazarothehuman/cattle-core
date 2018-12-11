package mz.co.basse.cattlecore.models.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
		entityManager.getTransaction().begin();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Procedimento> query = criteriaBuilder.createQuery(Procedimento.class);

		Root<Procedimento> root = query.from(Procedimento.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		Path<String> nomePath = root.<String>get("nome");
		Path<String> descricaoPath = root.<String>get("descricao");
		Path<Boolean> activePath = root.<Boolean>get("active");

		if (nome != null) {
			Predicate predicate = criteriaBuilder.equal(nomePath, nome);
			predicates.add(predicate);
		}

		if (descricao != null) {
			Predicate predicate = criteriaBuilder.equal(descricaoPath, descricao);
			predicates.add(predicate);

		}

		if (active != null) {
			Predicate predicate = criteriaBuilder.equal(activePath, active);
			predicates.add(predicate);
		}

		query.where(predicates.toArray(new Predicate[predicates.size()]));

		TypedQuery<Procedimento> typedQuery = entityManager.createQuery(query);
		entityManager.getTransaction().commit();
		return typedQuery.getResultList();
	}

}
