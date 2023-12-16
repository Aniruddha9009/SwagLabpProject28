package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.capturescreenshot;

public class Cart_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_page_2 invent;
	CartPage cart;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		login = new LoginPage();
		invent = new Inventory_page_2();
		cart = new CartPage();
		login.LoginToApplication();
		cart.VerifyshoppingCartPage();
	}
	
	@Test
	public void VerifyshoppingCartPageTest()
	{
		boolean Cart = cart.VerifyshoppingCartPage();
		Assert.assertEquals(Cart, true);
		Reporter.log("Shopping Cart of Inventory Page :- " + Cart);
	}
	
	@Test
	public void VerifyURLofCartPageTest() throws EncryptedDocumentException, IOException
	{
		String expURL = "https://www.saucedemo.com/cart.html"; //ReadData.readExcel(1, 2);
		String actURL = cart.VerifyURLofCartPage();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of Your Cart = " + actURL);
	}
	
	@Test
	public void verifyCartPageTitle() throws EncryptedDocumentException, IOException
	{
		String expTitle = "Your Cart"; //ReadData.readExcel(1, 3);
		String actTitle = cart.verifyCartPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of Your Cart = " + actTitle);
	}
	
	@Test
	public void verifyCartQualityLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable = "QTY";	//ReadData.readExcel(1, 4);
		String actLable = cart.verifyCartQTYLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Visibility of Cart Page QTY Lable = "+ actLable);
	}
	
	@Test
	public void verifyCartDescriptionLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable = "Description";	//ReadData.readExcel(1, 5);
		String actLable = cart.verifyCartDescriptionLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Visibility of Cart Page Description Lable = "+ actLable);
	}
	
	@Test
	public void verifyContinueShoppingCartBtnTest() throws EncryptedDocumentException, IOException
	{
		String expBtn = "Continue Shopping";	//ReadData.readExcel(1, 6);
		String actBtn = cart.verifyContinueShoppingCartBtn();
		Assert.assertEquals(expBtn, actBtn);
		Reporter.log("Continue Shopping Button of Cart Page = "+ actBtn);
	}
	
	@Test
	public void verifyCartCheckOutBtnTest()
	{
		String expBtn = "Checkout";
		String actBtn = cart.verifyCartCheckOutBtn();
		Assert.assertEquals(expBtn, actBtn);
		Reporter.log("CheckOut Button of Cart Page = "+ actBtn);
	}

	@Test
	public void verifyCartTwitterLogoTest()
	{
		boolean twitter = cart.verifyCartTwitterLogo();
		Assert.assertEquals(twitter, true);
		Reporter.log("Twitter Log of Cart Page = "+ twitter);
	}
	
	@Test
	public void verifyCartFacebookLogoTest()
	{
		boolean facebook = cart.verifyCartFacebookLogo();
		Assert.assertEquals(facebook, true);
		Reporter.log("Facebook Log of Cart Page = "+ facebook);
	}
	
	@Test
	public void verifyCartLinkedInLogoTest()
	{
		boolean linkedIn = cart.verifyCartLinkedInLogo();
		Assert.assertEquals(linkedIn, true);
		Reporter.log("LinkedIn Logo of Cart page = "+ linkedIn);
	}
	
	@Test
	public void verifyCart3linesTest()
	{
		boolean lines = cart.verifyCart3lines();
		Assert.assertEquals(lines, true);
		Reporter.log("Visibility of Cart Page OpenMenu = "+ lines);
	}
		
	@Test
	public void verifyFooterTxtCartPageTest()
	{
		boolean txt = cart.verifyFooterTextCartPage();
		Assert.assertEquals(txt, true);
		Reporter.log("Footer Text of Cart Page = "+ txt);
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
