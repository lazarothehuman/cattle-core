package mz.co.basse.cattlecore.models.dao;

import java.util.List;

import mz.co.basse.cattlecore.models.Coral;

public interface CoralDao {

	void create(Coral coral);

	List<Coral> find(Boolean active);

}
