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
import pages.CheckOutPage2;
import pages.CompletePage;
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.capturescreenshot;

public class CompletePage_Test extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	CartPage cart;
	CheckOutPage1 check1;
	CheckOutPage2 check2;
	CompletePage comp;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		login = new LoginPage();
		invent = new Inventory_page_2();
		cart = new CartPage();
		check1=new CheckOutPage1();
		check2=new CheckOutPage2();
		comp=new CompletePage();
		login.LoginToApplication();
		invent.add6Products();
		cart.VerifyshoppingCartPage();
		cart.ClickOnCheckOutPagebtn();
		check1.Inputinformation();
		check2.clickOnFinishBtn();
		
	}
	@Test
	public void VerifyURLofCompletePage() 
	{
		String expURL = "https://www.saucedemo.com/checkout-complete.html";
		String actURL = comp.VerifyURLofCompletePage();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of Complete Page = "+actURL);		
	}
	
	@Test
	public void VerifyCompletePageTitleTest()
	{
		String expTitle = "Checkout: Complete!";
		String actTitle = comp.VerifyCompletePageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of CompletePage = "+actTitle);
	}
	
	@Test
	public void  VerifyImageLogoTest()
	{
		boolean Logo = comp.VerifyImageLogo();
		Assert.assertEquals(Logo, true);
		Reporter.log("Display image of CompletePage = "+Logo);
	}
	
	@Test
	public void VerifyThankYouMsgTest()
	{
		String expMsg = "Thank you for your order!";
		String actMsg = comp.VerifyThankYouMsg();
		Assert.assertEquals(expMsg, actMsg);
		Reporter.log("Display 'Thank you for your order!' Message of CompletePage = "+actMsg);
	}
	
	@Test
	public void VerifyYourOrderMsgTest()
	{
		String expMsg = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actMsg = comp.VerifyYourOrderMsg();
		Assert.assertEquals(expMsg, actMsg);
		Reporter.log("Display Your Order Message of CompletePage = "+actMsg);
	}
	
	@Test
	public void VerifyBackHomeBtnTest()
	{
		String expBtn = "https://www.saucedemo.com/inventory.html";
		String actBtn = comp.VerifyBackHomeBtn();
		Assert.assertEquals(expBtn, actBtn);
		Reporter.log("BackHome Button of CompletePage :- "+actBtn);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if (it.FAILURE == it.getStatus())
		{
			capturescreenshot.screenshot(it.getName());
		}
		
		driver.close();
	}
	
}