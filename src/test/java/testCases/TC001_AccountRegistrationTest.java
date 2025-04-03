package testCases;

import java.time.Duration;
import testBase.BaseClass;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verifyAccountRegistration()
	{
		logger.info("*****starting TC001_AccountRegistrationTest ");
		try {
		HomePage hp =new HomePage(driver);  //created object of Homepage
		hp.clickMyAccount();
		logger.info("*****Clicked on My Account Link....");
		hp.clickRegister();
        
		logger.info("*****Clicked on My Register Link....");
		AccountRegistrationPage ar = new AccountRegistrationPage(driver);

		logger.info("*****Providing Customer details....");
		ar.setFirstName(randomString().toUpperCase()); //randomly generated the name
		ar.setLastName(randomString().toUpperCase());
		ar.setEmail(randomString()+"@gmail.com");  //randomly generated the email
		ar.setPhoneNum(randomNumber()); //randomly generated the phone number

		String password = randomAlphaNumeric();

		ar.setPassword(password);
		ar.setConfirmPswd(password);
		ar.checkPolicy();
		ar.clickContinue();
		ar.getConfirmationMsg();
		logger.info("*****Validating expected msg....");
		String confMsg = ar.getConfirmationMsg();
		
		if (confMsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
			
		}
		}catch (Exception e){
		//Assert.assertEquals(confMsg,"Your Account Has Been Created!");
	    
	}
		logger.info("*****Finished TC001_AccountRegistrationTest....");
	}
}
