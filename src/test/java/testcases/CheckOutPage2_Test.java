package testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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
import pages.Inventory_page_2;
import pages.LoginPage;
import utility.capturescreenshot;

public class CheckOutPage2_Test extends TestBase
{	LoginPage login;
	Inventory_page_2 invent;
	CartPage cart;
	CheckOutPage1 check1;
	CheckOutPage2 check2;
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		login = new LoginPage();
		invent = new Inventory_page_2();
		cart = new CartPage();
		check1=new CheckOutPage1();
		check2=new CheckOutPage2();
		login.LoginToApplication();
		cart.VerifyshoppingCartPage();
		cart.ClickOnCheckOutPagebtn();
		check1.Inputinformation();
		
	}
	
	@Test
	public void verifyLableTest()
	{
		String expLable="Checkout: Overview";
		String actLable=check2.verifyLable();
		Assert.assertEquals(expLable,actLable);
		Reporter.log("lable of checkoutPage2 = " + actLable);
	}
	@Test
	public void verifyPaymentInfoTextTest()
	{
		String expText="Payment Information";
		String actText=check2.verifyPaymentInfoText();
		Assert.assertEquals(expText,actText);
		Reporter.log("Text of checkoutpage2 PaymentInfo = " + actText);
	}
	@Test
	public void verifyShippingInfoTextTest()
	{
		String expText="Shipping Information";
		String actText=check2.verifyShippingInfoText();
		Assert.assertEquals(expText,actText);
		Reporter.log("Text of checkoutpage2 ShippingInfo = " + actText);
	}
	@Test
	public void verifyitemTotalTextTest()
	{
		String expText="Price Total";
		String actText=check2.verifyitemTotalText();
		Assert.assertEquals(expText,actText);
		Reporter.log("Text of checkoutpage2 item Total = " + actText);
	}
	@Test
	public void verifyTotalTextTest()
	{
		String expText="Total: $0.00";
		String actText=check2.verifyTotalText();
		Assert.assertEquals(expText,actText);
		Reporter.log("Text of total price = " + actText);
	}
	@Test
	public void verifyCancelBtnTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=check2.clickOnCancelBtn();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("URL of cancel button" + actURL);
	}
	@Test
	public void verifyclickOnFinishBtnTest()
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=check2.clickOnFinishBtn();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("URL of finish button" + actURL);
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