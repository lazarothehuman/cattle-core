package mz.co.basse.cattlecore.models.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mz.co.basse.cattlecore.models.Transaction;
import mz.co.basse.cattlecore.models.dao.TransactionDao;
import mz.co.basse.cattlecore.utils.JPAUtil;

public class TransactionJpaDao implements TransactionDao {
	
	private EntityManager entityManager = (EntityManager) new JPAUtil().getEntityManager();

	public void create(Transaction transaction) {
		entityManager.getTransaction().begin();
		entityManager.persist(transaction);
		entityManager.getTransaction().commit();
	}
	
	public void update(Transaction transaction) {
		entityManager.getTransaction().begin();
		entityManager.merge(transaction);
		entityManager.getTransaction().commit();
		
	}

	public Transaction find(String code) {
		entityManager.getTransaction().begin();
		TypedQuery<Transaction> query = entityManager.createQuery(
				"select transaction from Transaction transaction" + " where transaction.code = :code", Transaction.class);
		query.setParameter("code", code);
		List<Transaction> transactions = query.getResultList();
		entityManager.getTransaction().commit();
		if (transactions.isEmpty())
			return null;
		Transaction transaction = transactions.get(0);
		return transaction;
	}

}
