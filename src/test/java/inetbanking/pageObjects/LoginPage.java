package inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
	WebElement txtUserName;

	@FindBy(name = "password")
	WebElement txtpassword;

	@FindBy(name = "btnLogin")
	WebElement btnLogin;
	

	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement LnkLogout;

	public void setusername(String uname) {

		txtUserName.sendKeys(uname);

	}

	public void setpassword(String pwd) {

		txtpassword.sendKeys(pwd);

	}

	public void ClickSubmit() {

		btnLogin.click();

	}
	public void Logout()
	{
		
		LnkLogout.click();
	}

}
