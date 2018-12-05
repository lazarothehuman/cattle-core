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

import mz.co.basse.cattlecore.models.Animal;
import mz.co.basse.cattlecore.models.Classificacao;
import mz.co.basse.cattlecore.models.Coral;
import mz.co.basse.cattlecore.models.Gado;
import mz.co.basse.cattlecore.models.Raca;
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
		TypedQuery<Animal> query = entityManager
				.createQuery("select animal from Animal animal " + "where animal.code = :code", Animal.class);
		query.setParameter("code", code);
		List<Animal> animal = query.getResultList();
		if (animal.isEmpty()) {
			return null;
		}
		return animal.get(0);
	}

	public List<Animal> find(String selectedCode, Classificacao selectedClassificacao, Raca selectedRaca,
			Gado selectedTipo, Coral coral, Boolean active) {
		entityManager.getTransaction().begin();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Animal> query = criteriaBuilder.createQuery(Animal.class);

		Root<Animal> root = query.from(Animal.class);
		List<Predicate> predicates = new ArrayList<Predicate>();

		Path<String> codePath = root.<String>get("code");
		Path<Classificacao> classificacaoPath = root.<Classificacao>get("classificacao");
		Path<Raca> racaPath = root.<Raca>get("raca");
		Path<Gado> tipoPath = root.<Gado>get("tipo");
		Path<Coral> coralPath = root.<Coral>get("coral");
		Path<Boolean> activePath = root.<Boolean>get("active");

		if (selectedCode != null) {
			Predicate predicate = criteriaBuilder.equal(codePath, selectedCode);
			predicates.add(predicate);
		}

		if (selectedClassificacao != null) {
			Predicate predicate = criteriaBuilder.equal(classificacaoPath, selectedClassificacao);
			predicates.add(predicate);

		}

		if (selectedRaca != null) {
			Predicate predicate = criteriaBuilder.equal(racaPath, selectedRaca);
			predicates.add(predicate);
			
		}

		if (selectedTipo != null) {
			Predicate predicate = criteriaBuilder.equal(tipoPath, selectedTipo);
			predicates.add(predicate);
			
		}

		if (coral != null) {
			Predicate predicate = criteriaBuilder.equal(coralPath, coral);
			predicates.add(predicate);
		}

		if (active != null) {
			Predicate predicate = criteriaBuilder.equal(activePath, active);
			predicates.add(predicate);
		}

		query.where(predicates.toArray(new Predicate[predicates.size()]));

		TypedQuery<Animal> typedQuery = entityManager.createQuery(query);
		entityManager.getTransaction().commit();
		return typedQuery.getResultList();
	}
}
