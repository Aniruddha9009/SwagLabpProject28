package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckOutPage1;
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.capturescreenshot;

public class CheckOutPage1_Test extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	CartPage cart;
	CheckOutPage1 check1;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		login = new LoginPage();
		invent = new Inventory_page_2();
		cart = new CartPage();
		check1=new CheckOutPage1();
		login.LoginToApplication();
		cart.VerifyshoppingCartPage();
		cart.ClickOnCheckOutPagebtn();
	}
	@Test
	public void verifyURlOfCheckOutPage1()
	{
		String expURL="https://www.saucedemo.com/checkout-step-one.html";
		String actURL=check1.verifyURLOfCheckOutPage1();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("URL Of CheckOut page1 = " + actURL);
	}
	@Test
	public void verifyTitleofApplicationTet()
	{
		String expTitle="Checkout: Your Information";
		String actTitle=check1.verifyTitleOfApplication();
		Assert.assertEquals(expTitle,actTitle);
		Reporter.log("Title of checkOut Page = " + actTitle);
	}
	@Test
	public void InputinformationTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=check1.Inputinformation();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("Title of CheckOut page 2 = " + actURL);
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