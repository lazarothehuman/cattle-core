package mz.co.basse.cattlecore.models.dao;

import java.util.List;

import mz.co.basse.cattlecore.models.Procedimento;

public interface ProcedimentoDao {

	void create(Procedimento procedimento);

	List<Procedimento> find(String nome, String descricao, Boolean active);

}
