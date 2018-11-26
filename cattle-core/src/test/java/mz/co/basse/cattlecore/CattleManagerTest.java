package mz.co.basse.cattlecore;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import mz.co.basse.cattlecore.managers.CattleManager;
import mz.co.basse.cattlecore.managers.CattleManagerImp;
import mz.co.basse.cattlecore.models.Coral;
import mz.co.basse.cattlecore.models.Procedimento;

public class CattleManagerTest {
	
	CattleManager cattleManager = new CattleManagerImp();

	@Ignore
	@Test
	public void createCoralTest() {
		Coral coral = new Coral();
		coral.setLocalizacao("Panda");
		coral.setCode("01");
		cattleManager.createCoral(coral);
		Assert.assertNotNull(coral.getId());
	}
	
	@Test
	public void findActiveCoralTest() {
		List<Coral> corais = cattleManager.findCorais(true);
		Assert.assertNotNull(corais);
		Assert.assertEquals(3, corais.size());
	}
	
	@Ignore
	@Test
	public void createProcedimentoTest() {
		Procedimento procedimento = new Procedimento();
		procedimento.setNome("blalbalba");
		procedimento.setDescricao("blablalba");
		cattleManager.createProcedimento(procedimento);
		Assert.assertNotNull(procedimento.getId());
	}
	
	

}
