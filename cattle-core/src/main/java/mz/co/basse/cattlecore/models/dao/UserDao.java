package mz.co.basse.cattlecore.models.dao;

import java.util.List;

import mz.co.basse.cattlecore.models.Profile;
import mz.co.basse.cattlecore.models.User;

public interface UserDao {

	void create(User user);

	void update(User user);

	User find(String login);

	List<User> find(String name, Profile profile, Boolean active);

}
