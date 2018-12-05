package mz.co.basse.cattlecore.models.dao;

import java.util.List;

import mz.co.basse.cattlecore.models.Animal;
import mz.co.basse.cattlecore.models.Classificacao;
import mz.co.basse.cattlecore.models.Coral;
import mz.co.basse.cattlecore.models.Gado;
import mz.co.basse.cattlecore.models.Raca;

public interface AnimalDao {

	void create(Animal animal);

	Animal find(String code);

	List<Animal> find(String selectedCode, Classificacao selectedClassificacao, Raca selectedRaca, Gado selectedTipo,
			Coral coral, Boolean active);

	void update(Animal animal);

}
