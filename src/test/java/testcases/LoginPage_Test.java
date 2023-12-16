package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.ReadData;
import utility.capturescreenshot;

public class LoginPage_Test extends TestBase 
{	
	LoginPage Login;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		Login=new LoginPage();
	}
	@Test (enabled=true,priority=2,groups = "Sanity")
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExcel(0,0);//Swag Labs(0,0)
		String actTitle=Login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle,actTitle );
	}
	@Test (enabled=true,priority=1,groups = {"Sanity","Retesting"})
	public void verifyURLofApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL=ReadData.readExcel(0,1);//https://www.saucedemo.com/(0,1)
		String actURL=Login.verifyURLofApplication();
		Assert.assertEquals(expURL, actURL);
	}
	@Test (enabled=true,priority=3,groups = "Regression")
	public void LoginToApplicationTest() throws IOException
	{
		String expURl=ReadData.readExcel(0,2);//https://www.saucedemo.com/inventory.html(0,2)
		String actURL=Login.LoginToApplication();
		assertEquals(expURl, actURL);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.FAILURE==it.getStatus())
		{
			capturescreenshot.screenshot(it.getName());
		}
		report.flush();
		driver.close();
	}
}