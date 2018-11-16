package mz.co.basse.cattlecore.models.dao;

import mz.co.basse.cattlecore.models.User;

public interface UserDao {

	void create(User user);

	void update(User user);

	User find(String login);

}
