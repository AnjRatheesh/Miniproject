package inetbanking.testCases;

import java.io.File;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.testng.annotations.Test;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import inetbanking.pageObjects.LoginPage;
import inetbanking.utilities.XLUtils;

public class Tc_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void LoginDDT(String user, String pwd) throws IOException {
		LoginPage lp = new LoginPage(driver);
		driver.manage().window().maximize();
		lp.setusername(user);
		logger.info("Username entered");
		lp.setpassword(pwd);
		logger.info("Password enetered");
		lp.ClickSubmit();
		if (isAlertPresent() == true) {
			
			
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login Failed due to invalid credetials");
		} else {
			Assert.assertTrue(true);
			lp.Logout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();

		}

	}

	public Boolean isAlertPresent() {

		try {
			driver.switchTo().alert();
			
			return true;
			

		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/inetbanking/testdata/LoginData.xlsx";
		int rowcount = XLUtils.getRowCount(path, "DataSheet1");
		int colcount = XLUtils.getCellCount(path, "DataSheet1", 1);
		String ldata[][] = new String[rowcount][colcount];
		for (int i = 1; i <= rowcount; i++) {
			for (int j = 0; j < colcount; j++) {
				ldata[i - 1][j] = XLUtils.getCellData(path, "DataSheet1", i, j);
			}

		}
		return ldata;
	}

}
