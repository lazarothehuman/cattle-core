package mz.co.basse.cattlecore.models.dao;

import mz.co.basse.cattlecore.models.Animal;

public interface AnimalDao {

	void create(Animal animal);

	Animal find(String code);

}
