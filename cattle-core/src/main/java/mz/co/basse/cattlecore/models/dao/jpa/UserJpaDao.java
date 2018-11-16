package mz.co.basse.cattlecore.models.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mz.co.basse.cattlecore.models.User;
import mz.co.basse.cattlecore.models.dao.UserDao;
import mz.co.basse.cattlecore.utils.JPAUtil;

public class UserJpaDao implements UserDao {
	
	private EntityManager entityManager = (EntityManager) new JPAUtil().getEntityManager();

	public void create(User user) {
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();

	}

	public void update(User user) {
		entityManager.getTransaction().begin();
		entityManager.merge(user);
		entityManager.getTransaction().commit();

	}

	public User find(String login) {
		entityManager.getTransaction().begin();
		TypedQuery<User> query = entityManager.createQuery(
				"select user from User user" + " where user.login = :login", User.class);
		query.setParameter("login", login);
		List<User> users = query.getResultList();
		entityManager.getTransaction().commit();
		if (users.isEmpty())
			return null;
		User user = users.get(0);
		return user;
	}

}
