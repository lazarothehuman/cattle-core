package mz.co.basse.cattlecore.managers;

import java.util.List;

import mz.co.basse.cattlecore.models.Profile;
import mz.co.basse.cattlecore.models.Transaction;
import mz.co.basse.cattlecore.models.User;


public interface AccessControlManager {

	void createTransaction(Transaction transaction);

	List<Profile> findProfiles(Transaction transaction, Boolean active);

	List<Transaction> findTransactions();

	void createOrUpdateProfile(Profile profile);

	Profile findProfile(String name);

	List<User> findUsers(String name, Profile profile, Boolean active);

	User findUser(String login);

	void encryptUserPassword(User user);

	boolean isPasswordMatches(String plainPassword, String encryptedPassword);

	void createUser(User user, User registrator);

	void updateUser(User user, User registrator);

	Transaction findTransaction(String code);

	List<Profile> findProfiles(Boolean active);

	void updateTransaction(Transaction transaction);
}
