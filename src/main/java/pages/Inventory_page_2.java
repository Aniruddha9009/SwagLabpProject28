package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import utility.HandleDropdownList;

public class Inventory_page_2 extends TestBase
{
	//object repository
	@FindBy(xpath="//span[@class='title']") private WebElement ProductLable;
	@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement AddToCart;
	@FindBy(xpath="//div[@class='shopping_cart_container']") private WebElement CartCount;
	@FindBy(xpath="//select[@class='product_sort_container']") private WebElement dropDown;
	//element added to the cart
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backPackProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement SauceLabsBikeLight;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement BoltTShirtProduct;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement FleeceJacket;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement SauceLabsOnesieProduct;
	@FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement TestallTheThingsTShirtRed;
	//checking visibility
	@FindBy(xpath="//button[@id='react-burger-menu-btn']") private WebElement MenuBtn;
	@FindBy(xpath="//div[@class='app_logo']") private WebElement AppLogo;
	@FindBy(xpath="//li[@class='social_twitter']") private WebElement TwitterLogo;
	@FindBy(xpath="//li[@class='social_facebook']") private WebElement FacebookLogo;
	@FindBy(xpath="//li[@class='social_linkedin']") private WebElement LinkdinLogo;
	//element removed
	@FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement removebackPackProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement removeSauceLabsBikeLight;
	@FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeBoltTshirtProduct;
	@FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removeFleeceJaclet;
	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement removeSauceLabsOnesieProduct;
	@FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeTestallTheThingsTShirtRed;
	
	
	//constrctor
	public Inventory_page_2()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyProductLable()
	{
		return ProductLable.getText();
	}
	public String verifyAppLogo()
	{
		return AppLogo.getText();
	}
	public boolean verifyTwitterLogo()
	{
		return TwitterLogo.isDisplayed();
	}
	public boolean verifyFacebookLogo()
	{
		return FacebookLogo.isDisplayed();
	}
	public boolean verifyLinkdinLogo()
	{
		return LinkdinLogo.isDisplayed();
	}
	public String add6Products()
	{
		HandleDropdownList.handleselectclass(dropDown, "Price (low to high)"); 
		backPackProduct.click();
		SauceLabsBikeLight.click();
		BoltTShirtProduct.click();
		FleeceJacket.click();
		SauceLabsOnesieProduct.click();
		TestallTheThingsTShirtRed.click();
		return CartCount.getText();	
	}
	public String remove6Products() throws InterruptedException
	{
		add6Products();
		Thread.sleep(2000);
		removebackPackProduct.click();
		removeSauceLabsBikeLight.click();
		removeBoltTshirtProduct.click();
		removeFleeceJaclet.click();
		removeSauceLabsOnesieProduct.click();
		removeTestallTheThingsTShirtRed.click();
		return CartCount.getText();
	}		
}