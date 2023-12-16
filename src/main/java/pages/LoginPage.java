package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{
	@FindBy(xpath="//input[@name='user-name']") private WebElement useTxtBox;
	@FindBy(xpath="//input[@name='password']") private WebElement passwordTxtBox;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginBtn;
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String LoginToApplication() throws IOException
	{
		logger=report.createTest("Login To Sauce Lab Application");
		useTxtBox.sendKeys(ReadData.readPropertyFile("UserName"));
		logger.log(Status.INFO, "User Name is entered");
		passwordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		logger.log(Status.INFO, "Password is entered");
		loginBtn.click();
		logger.log(Status.INFO,"Log in Button is clicked");
		logger.log(Status.PASS,"Login is Successful");
		return driver.getCurrentUrl();
	}
	public String LoginToAppWithMultiCreds(String un, String pass)
	{
		useTxtBox.sendKeys(un);
		passwordTxtBox.sendKeys(pass);
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
	
	}
	public String verifyURLofApplication()
	{
		return driver.getCurrentUrl();
	}
}