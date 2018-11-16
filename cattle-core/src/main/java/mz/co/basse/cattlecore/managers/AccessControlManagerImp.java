package mz.co.basse.cattlecore.managers;

import java.util.List;

import mz.co.basse.cattlecore.models.Profile;
import mz.co.basse.cattlecore.models.Transaction;
import mz.co.basse.cattlecore.models.User;
import mz.co.basse.cattlecore.models.dao.ProfileDao;
import mz.co.basse.cattlecore.models.dao.TransactionDao;
import mz.co.basse.cattlecore.models.dao.UserDao;
import mz.co.basse.cattlecore.models.dao.jpa.ProfileJpaDao;
import mz.co.basse.cattlecore.models.dao.jpa.TransactionJpaDao;
import mz.co.basse.cattlecore.models.dao.jpa.UserJpaDao;

public class AccessControlManagerImp implements AccessControlManager {

	UserDao userDao = new UserJpaDao();
	ProfileDao profileDao = new ProfileJpaDao();
	TransactionDao transactionDao = new TransactionJpaDao();


	public void createTransaction(Transaction transaction) {
		if (transaction != null) {
			transactionDao.create(transaction);
		}
	}

	public List<Profile> findProfiles(Transaction transaction, Boolean active) {
		return null;
	}

	public List<Transaction> findTransactions() {
		// TODO Auto-generated method stub
		return null;
	}

	public void createOrUpdateProfile(Profile profile) {
		if (profile.getId() == null)
			profileDao.create(profile);
		else
			profileDao.update(profile);
	}

	public Profile findProfile(String name) {
		return profileDao.findProfile(name);
	}

	public List<User> findUsers(String name, Profile profile, Boolean active) {
		// TODO Auto-generated method stub
		return null;
	}

	public User findUser(String login) {
		return userDao.find(login);
	}

	public void encryptUserPassword(User user) {
		// TODO Auto-generated method stub

	}

	public boolean isPasswordMatches(String plainPassword, String encryptedPassword) {
		// TODO Auto-generated method stub
		return false;
	}


	public void createUser(User user, User registrator) {
		if (user != null)
			userDao.create(user);
	}

	public void updateUser(User user, User registrator) {
		if (user != null)
			userDao.update(user);

	}

	public Transaction findTransaction(String code) {
		return transactionDao.find(code);
	}

	public List<Profile> findProfiles(Boolean active) {
		return profileDao.find(active);
	}

	public void updateTransaction(Transaction transaction) {
		if (transaction != null) {
			transactionDao.update(transaction);
		}
		
	}

}
