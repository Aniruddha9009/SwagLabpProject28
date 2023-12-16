package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CompletePage extends TestBase
{
	@FindBy(xpath = "//span[@class='title']") private WebElement CompletePageTitle;
	@FindBy(xpath = "//img[@class='pony_express']") private WebElement ImageLogo;
	@FindBy(xpath = "//h2[@class='complete-header']") private WebElement ThankYouMsg;
	@FindBy(xpath = "//div[@class='complete-text']") private WebElement YourOrderMsg;
	@FindBy(xpath = "//button[@name='back-to-products']") private WebElement BackHomeBtn;

	public CompletePage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyURLofCompletePage()
	{
		return driver.getCurrentUrl();
	}
	
	public String VerifyCompletePageTitle()
	{
		return CompletePageTitle.getText();
	}
	
	public boolean VerifyImageLogo()
	{
		return ImageLogo.isDisplayed();
	}
	
	public String VerifyThankYouMsg()
	{
		return ThankYouMsg.getText();
	}
	 
	public String VerifyYourOrderMsg()
	{
		return YourOrderMsg.getText();
	}
	
	public String VerifyBackHomeBtn()
	{
		BackHomeBtn.click();
		return driver.getCurrentUrl();
	}
}