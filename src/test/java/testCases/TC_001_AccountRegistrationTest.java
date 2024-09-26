package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test
	public void verify_account_registration() {
		
		logger.info("************Starting TC_001_AccountRegistrationTest*************");
		
		try 
		{
		HomePage hp=new HomePage(driver);
		
		hp.myAccountClick();
		logger.info("Clicked on MyAccount Link....");
		
		hp.registerClick();
		logger.info("Clicked on Register Link....");
		
		RegisterPage rp=new RegisterPage(driver);
		
		logger.info("Providing User Details....");
		
		rp.setfrstName(randomString().toUpperCase());
		rp.setlastName(randomString().toUpperCase());
		rp.setEmail(randomString()+"@gmail.com");
		rp.setTelephone(randomNumber());
		
		String password = randmAlphaNumeric();
		
		rp.setPassword(password);
		rp.setCnfrmPassword(password);
		
		rp.checkPrivacybox();
		rp.clickContinue();
		
		
		logger.info("Validating Expected Message.....");
		
		String cnfrmmsg = rp.getCnfrmMesssage();
		
		if (cnfrmmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test Failed....");
			logger.debug("Debug logs.....");
			Assert.assertTrue(false);
			
		}
		//Assert.assertEquals(cnfrmmsg,"Your Account Has Been Created!");
		}
		catch (Exception e) {
			Assert.fail("Test Failed....");
		}
		
		logger.info("************Finished TC_001_AccountRegistrationTest*************");
		
	}
	
	
	
	
	

}
