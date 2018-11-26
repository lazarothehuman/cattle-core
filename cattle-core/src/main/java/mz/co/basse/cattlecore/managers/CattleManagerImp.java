package mz.co.basse.cattlecore.managers;

import java.util.List;

import mz.co.basse.cattlecore.models.Coral;
import mz.co.basse.cattlecore.models.Procedimento;
import mz.co.basse.cattlecore.models.dao.CoralDao;
import mz.co.basse.cattlecore.models.dao.ProcedimentoDao;
import mz.co.basse.cattlecore.models.dao.jpa.CoralJpaDao;
import mz.co.basse.cattlecore.models.dao.jpa.ProcedimentoJpaDao;

public class CattleManagerImp implements CattleManager {

	CoralDao coralDao = new CoralJpaDao();
	ProcedimentoDao procedimentoDao = new ProcedimentoJpaDao();

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

}
