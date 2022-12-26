package inetbanking.testCases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import inetbanking.pageObjects.LoginPage;



public class Tc_LoginTest_001 extends BaseClass {
	@Test
	public void LoginTest() throws InterruptedException, IOException
	{
		
		logger.info("URL is Openend");
		driver.manage().window().maximize();
		
		LoginPage lp=new LoginPage(driver);
		lp.setusername(uname);
		logger.info("Entered username");
		lp.setpassword(pwd);
		logger.info("Entered password");
		lp.ClickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
			else
			{
				captureScreeshot(driver,"LoginTest","Screeshotfilename");
				Assert.assertTrue(false);
				logger.info("Login Test Failed");
			}
		
		
	}
	
	

}
