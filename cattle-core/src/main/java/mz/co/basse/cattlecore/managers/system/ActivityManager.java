package mz.co.basse.cattlecore.managers.system;

public interface ActivityManager {
	
	public void registerLogIn();
	public void registerTransactionEnter();
	public void registerSuccesfulTransaction();
	public void regiterUnsucessfulTransaction();
	public void registerLogOut();
	

}
