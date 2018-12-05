package mz.co.basse.cattlecore.managers;

import java.util.List;

import mz.co.basse.cattlecore.models.Animal;
import mz.co.basse.cattlecore.models.Classificacao;
import mz.co.basse.cattlecore.models.Coral;
import mz.co.basse.cattlecore.models.Gado;
import mz.co.basse.cattlecore.models.Procedimento;
import mz.co.basse.cattlecore.models.Raca;
import mz.co.basse.cattlecore.models.dao.AnimalDao;
import mz.co.basse.cattlecore.models.dao.CoralDao;
import mz.co.basse.cattlecore.models.dao.ProcedimentoDao;
import mz.co.basse.cattlecore.models.dao.jpa.AnimalJpaDao;
import mz.co.basse.cattlecore.models.dao.jpa.CoralJpaDao;
import mz.co.basse.cattlecore.models.dao.jpa.ProcedimentoJpaDao;

public class CattleManagerImp implements CattleManager {

	CoralDao coralDao = new CoralJpaDao();
	ProcedimentoDao procedimentoDao = new ProcedimentoJpaDao();
	AnimalDao animalDao = new AnimalJpaDao();

	public void createCoral(Coral coral) {
		if (coral != null) {
			coralDao.create(coral);
		}

	}

	public List<Coral> findCorais(Boolean active) {
		return coralDao.find(active);
	}

	public void createProcedimento(Procedimento procedimento) {
		if (procedimento != null) {
			procedimentoDao.create(procedimento);
		}
		
	}

	public List<Procedimento> findProcedimentos(String nome, String descricao, Boolean active) {
		return procedimentoDao.find(nome,descricao,active);
	}

	public void createAnimal(Animal animal) {
		if (animal != null) {
			animalDao.create(animal);
		}
		
	}

	public Animal findAnimal(String code) {
		return animalDao.find(code);
	}

	public Coral findCoral(String coralCode) {
		return coralDao.find(coralCode);
	}

	public List<Animal> findAnimais(String selectedCode, Classificacao selectedClassificacao, Raca selectedRaca,
			Gado selectedTipo, Coral coral, Boolean active) {
		return animalDao.find(selectedCode,selectedClassificacao, selectedRaca, selectedTipo, coral, active);
	}

	public void updateAnimal(Animal animal) {
		if (animal != null) {
			animalDao.update(animal);
		}
		
	}

}
