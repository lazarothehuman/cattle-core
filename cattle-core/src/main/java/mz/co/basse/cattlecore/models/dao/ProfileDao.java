package mz.co.basse.cattlecore.models.dao;

import java.util.List;

import mz.co.basse.cattlecore.models.Profile;

public interface ProfileDao {

	void create(Profile profile);

	void update(Profile profile);

	Profile findProfile(String name);

	List<Profile> find(Boolean active);

}
