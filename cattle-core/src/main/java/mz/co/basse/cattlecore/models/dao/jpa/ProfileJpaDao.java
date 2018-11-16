package mz.co.basse.cattlecore.models.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mz.co.basse.cattlecore.models.Profile;
import mz.co.basse.cattlecore.models.dao.ProfileDao;
import mz.co.basse.cattlecore.utils.JPAUtil;

public class ProfileJpaDao implements ProfileDao {

	private EntityManager entityManager = (EntityManager) new JPAUtil().getEntityManager();

	public void create(Profile profile) {
		entityManager.getTransaction().begin();
		entityManager.persist(profile);
		entityManager.getTransaction().commit();

	}

	public void update(Profile profile) {
		entityManager.getTransaction().begin();
		entityManager.merge(profile);
		entityManager.getTransaction().commit();

	}

	public Profile findProfile(String name) {
		entityManager.getTransaction().begin();
		TypedQuery<Profile> query = entityManager.createQuery(
				"select profile from Profile profile" + " where profile.name = :profilename", Profile.class);
		query.setParameter("profilename", name);
		List<Profile> profiles = query.getResultList();
		entityManager.getTransaction().commit();
		if (profiles.isEmpty())
			return null;
		Profile profile = profiles.get(0);
		return profile;
	}

	public List<Profile> find(Boolean active) {
		entityManager.getTransaction().begin();
		TypedQuery<Profile> query = entityManager
				.createQuery("select profile from Profile profile" + " where profile.active = :active", Profile.class);
		query.setParameter("active", active);
		List<Profile> profiles = query.getResultList();
		entityManager.getTransaction().commit();
		if (profiles.isEmpty())
			return null;
		else
			return profiles;
	}

}
