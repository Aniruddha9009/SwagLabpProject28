package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.capturescreenshot;

public class VerifyMultipleCredentials_Test extends TestBase 
{
	LoginPage Login;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		Login=new LoginPage();
	}
	@DataProvider(name="Credentials")
	public Object[][]getData()
	{
		return new Object[][]
				{
					{"standard_user","secret_sauce"},//RU,RP
					{"standard_user1","secret_sauce"},//WU,RP
					{"standard_user","secret_sauce1"},//RU,WP
					{"standard_user1","secret_sauce1"},//WU,WP
				};
				
	}
	@Test(dataProvider = "Credentials")
	public void LoginToAppWithMultiCredsTest(String un, String pass)
	{
		SoftAssert s=new SoftAssert();
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=Login.LoginToAppWithMultiCreds(un, pass);
		s.assertEquals(expURL, actURL);
		s.assertAll(); 
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			capturescreenshot.screenshot(it.getName());
		}
			driver.close();
	}
}