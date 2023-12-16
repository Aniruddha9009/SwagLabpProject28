package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.ReadData;

public class Inventorypage2Test extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_page_2();
		login.LoginToApplication();
	}
	@Test(groups = "Sanity")
	public void verifyProductLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable=ReadData.readExcel(0,3);//Products(0,3)
		String actLable=invent.verifyProductLable();
		Assert.assertEquals(expLable,actLable);
		Reporter.log("Lable of Inventory page = " + actLable);
	}
	@Test
	public void verifyAppLogoTest()
	{
		String explogo="Swag Labs";
		String actLogo=invent.verifyAppLogo();
		Assert.assertEquals(explogo,actLogo);
		Reporter.log("Logo of Inventory page = " + actLogo);
	}
	@Test(groups = "Retesting")
	public void verifyTwitterLogoTest()
	{
		boolean result=invent.verifyTwitterLogo();
		Assert.assertEquals(result,true);
		Reporter.log("visibility of twitter logo = "+ result);
	}
	@Test 
	public void verifyFacebookLogoTest()
	{
		boolean result=invent.verifyFacebookLogo();
		Assert.assertEquals(result,true);
		Reporter.log("visibility of facebook logo = "+ result);
	}
	@Test 
	public void verifyLinkdinLogoTest()
	{
		boolean result=invent.verifyLinkdinLogo();
		Assert.assertEquals(result,true);
		Reporter.log("visibility of Linkdin logo = "+ result);
	}
	@Test(groups = {"Retesting","Regression"}) 
	public void add6ProductsTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0,4);//6(0,4)
		String actCount=invent.add6Products();
		Assert.assertEquals(expCount,actCount);
		Reporter.log("Total products added to cart = "+ actCount); 
	}
	@Test(groups = {"Retesting","Regression"}) 
	public void remove6ProductsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExcel(0,5);//0(0,5)
		String actCount=invent.remove6Products();
		Assert.assertEquals(expCount,actCount);
		Reporter.log( "count of products after removing" + actCount);
	}
	@AfterMethod(alwaysRun = true)
	public void closeBrowser()
	{
		driver.close();
	} 
	
}