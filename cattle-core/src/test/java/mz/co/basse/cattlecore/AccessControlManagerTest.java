package mz.co.basse.cattlecore;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import mz.co.basse.cattlecore.managers.AccessControlManager;
import mz.co.basse.cattlecore.managers.AccessControlManagerImp;
import mz.co.basse.cattlecore.models.Profile;
import mz.co.basse.cattlecore.models.Transaction;
import mz.co.basse.cattlecore.models.User;

public class AccessControlManagerTest {

	AccessControlManager accesControlManager = new AccessControlManagerImp();

	@Ignore
	@Test
	public void createProfileTest() {// work
		Profile profile = new Profile();
		profile.setName("Administrador de Informática");
		// profile.setTransactions(transactionDao.findTransactions(true));
		accesControlManager.createOrUpdateProfile(profile);
		Assert.assertNotNull(profile.getId());
		Assert.assertTrue(profile.isActive());

	}

	@Ignore
	@Test
	public void updateProfileTest() {// work
		Profile selectedProfile = accesControlManager.findProfile("Administrador de Informática");
		selectedProfile.setName("Administrador");
		accesControlManager.createOrUpdateProfile(selectedProfile);
		Assert.assertNotNull(selectedProfile);
		Assert.assertEquals("Administrador", selectedProfile.getName());
	}

	@Test
	public void findActiveProfilesTest() {//work
		List<Profile> profiles = accesControlManager.findProfiles(Boolean.TRUE);
		Assert.assertNotNull(profiles);
		Assert.assertEquals(1, profiles.size());
		Assert.assertEquals("Administrador de Informática", profiles.get(0).getName());
	}
	
	@Ignore
	@Test
	public void createTransactionTest() {//work
		Transaction transaction = new Transaction();
		transaction.setCode("main");
		transaction.setName("Main ");
		transaction.setUrl("/access/hellos");
		accesControlManager.createTransaction(transaction);
		
	}
	
	@Ignore
	@Test
	public void updateTransactionTest() {//work
		Transaction transaction = accesControlManager.findTransaction("main");
		transaction.setCode("main2");
		transaction.setName("Main ");
		transaction.setUrl("/access/hellos");
		accesControlManager.updateTransaction(transaction);
	}
	
	@Test
	public void findUserByLoginTest() {
		User user = accesControlManager.findUser("lazaro");
		Assert.assertNotNull(user);
		
	}
	
	@Ignore
	@Test
	public void createUserTest() {
		Profile profile = accesControlManager.findProfile("Administrador");
		User user = new User();
		user.setLogin("lazaro");
		user.setName("Lazaro Sebastiao Mathe Junior");
		user.setPassword("1234");
		user.setProfile(profile);
		user.setPhone("+258825004957");
		//accesControlManager.createUser(user, registrator);
	}
	
	
	
	

}
