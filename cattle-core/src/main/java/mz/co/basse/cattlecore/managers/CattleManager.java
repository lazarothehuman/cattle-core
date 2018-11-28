package mz.co.basse.cattlecore.managers;

import java.util.List;

import mz.co.basse.cattlecore.models.Coral;
import mz.co.basse.cattlecore.models.Procedimento;

public interface CattleManager {

	void createCoral(Coral coral);

	List<Coral> findCorais(Boolean active);

	void createProcedimento(Procedimento procedimento);

	List<Procedimento> findProcedimentos(String nome, String descricao, Boolean active);

}
