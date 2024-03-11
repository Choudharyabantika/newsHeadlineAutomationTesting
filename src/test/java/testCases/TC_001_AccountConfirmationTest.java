package testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import testBase.BaseClass;
import utilities.Screenshot;

public class TC_001_AccountConfirmationTest extends BaseClass {
	
	
	
	
	@Test(priority=1)
	public void verify_username() throws InterruptedException, IOException {
		logger.info("****** Starting TC_001_AccountConfirmationTest ******");
		logger.debug("Application logs started");
		try {
		HomePage hp=new HomePage(driver);
		Thread.sleep(3000);
		hp.clickMyAccount();
		
		logger.info("Clicked on side profile initials ");
		
		
		
		Thread.sleep(1000);
		String username=hp.getUsername();
		logger.info("Fetching username");
		
		Thread.sleep(1000);
		String mail=hp.getmail();
		logger.info("Fetching user mail Id");
		
		Screenshot ss=new Screenshot();
		ss.takeFullScreenShot("Signin", driver);
		logger.info("ScreenShot of side profile");
		Thread.sleep(3000);
		
		System.out.println(username+" Username");
		System.out.println(mail+" mail");
		
		System.out.println("===============================================");
		
		Thread.sleep(2000);
		logger.info("Validating expected username and mail Id");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(username,"Choudhary, Abantika (Cognizant)");
		soft.assertEquals(mail,"2303514@cognizant.com");
		soft.assertAll(); //mandatory
		logger.info("Test case passed");
		logger.info("******  TC_001_AccountConfirmationTest finished******");
		}catch(Exception e) {
			logger.error("test failed");
			
		}
		
	}

	
	

}
