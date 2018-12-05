package mz.co.basse.cattlecore.managers;

import java.util.List;

import mz.co.basse.cattlecore.models.Animal;
import mz.co.basse.cattlecore.models.Classificacao;
import mz.co.basse.cattlecore.models.Coral;
import mz.co.basse.cattlecore.models.Gado;
import mz.co.basse.cattlecore.models.Procedimento;
import mz.co.basse.cattlecore.models.Raca;

public interface CattleManager {

	void createCoral(Coral coral);

	List<Coral> findCorais(Boolean active);

	void createProcedimento(Procedimento procedimento);

	List<Procedimento> findProcedimentos(String nome, String descricao, Boolean active);

	void createAnimal(Animal animal);

	Animal findAnimal(String codePai);

	Coral findCoral(String coralCode);

	List<Animal> findAnimais(String selectedCode, Classificacao selectedClassificacao, Raca selectedRaca,
			Gado selectedTipo, Coral coral, Boolean true1);

	void updateAnimal(Animal animal);

}
