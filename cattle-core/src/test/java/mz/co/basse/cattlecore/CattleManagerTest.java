package mz.co.basse.cattlecore;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import mz.co.basse.cattlecore.managers.CattleManager;
import mz.co.basse.cattlecore.managers.CattleManagerImp;
import mz.co.basse.cattlecore.models.Animal;
import mz.co.basse.cattlecore.models.Classificacao;
import mz.co.basse.cattlecore.models.Coral;
import mz.co.basse.cattlecore.models.Gado;
import mz.co.basse.cattlecore.models.Procedimento;
import mz.co.basse.cattlecore.models.Raca;
import mz.co.basse.cattlecore.models.Saida;
import mz.co.basse.cattlecore.models.Sexo;
import mz.co.basse.cattlecore.models.TipoSaida;

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
	
	@Ignore
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
	
	@Ignore
	@Test
	public void createAnimalTest() {//mudar para apenas um find
		Coral coral = cattleManager.findCorais(Boolean.TRUE).get(0);
		Animal animal = new Animal();
		animal.setCor("Branco");
		animal.setDataNascimento(new Date());
		animal.setCoral(coral);
		animal.setRaca(Raca.Brahman);
		animal.setCode("112");
		animal.setTipo(Gado.Bovino);
		animal.setSexo(Sexo.Feminino);
		animal.setClassificacao(Classificacao.Novilha);
		cattleManager.createAnimal(animal);
		Assert.assertNotNull(animal.getId());
	}
	
	@Test
	public void findAnimalByCodeTest() {
		Animal animal = cattleManager.findAnimal("112");
		Assert.assertNotNull(animal);
		Assert.assertEquals("Azul", animal.getCor());
	}
	
	@Test
	public void findCoralByCodeTest() {
		Coral coral = cattleManager.findCoral("01");
		Assert.assertNotNull(coral);
	}
	
	@Ignore
	@Test
	public void findAnimalWithParameters() {
		List<Animal> animais = cattleManager.findAnimais(null, null, Raca.Brahman, null, null, Boolean.TRUE);
		Assert.assertNotNull(animais);
		Assert.assertEquals(1, animais.size());
	}
	
	@Test
	public void findProcedimentoWithParameters() {
		List<Procedimento> procedimentos = cattleManager.findProcedimentos("blalbalba", null, true);
		Assert.assertNotNull(procedimentos);
		Assert.assertEquals(1, procedimentos.size());
	}
	
	@Ignore
	@Test
	public void updateAnimalTest() {
		Animal animal = cattleManager.findAnimal("112");
		animal.setCor("Azul");
		cattleManager.updateAnimal(animal);
		Assert.assertNotNull(animal);
		Assert.assertEquals("Azul", animal.getCor());
	}
	
	
	@Test
	public void registerSaidaAnimaltest() {
		Animal animal = cattleManager.findAnimal("112");
		Saida saida = new Saida();
		saida.setAnimal(animal);
		saida.setNome("Saida");
		saida.setDescricao("Vendido para ");
		
		
	}
	

}
