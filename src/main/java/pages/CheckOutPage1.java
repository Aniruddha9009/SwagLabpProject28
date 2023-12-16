package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage1 extends TestBase
{
	//Object repository
	@FindBy(xpath="//span[@class='title']") private WebElement titleOfCheckOutPage;
	@FindBy(xpath="//input[@name='firstName']") private WebElement FirstNameTextBox;
	@FindBy(xpath="//input[@name='lastName']") private WebElement LastNameTextBox;
	@FindBy(xpath="//input[@name='postalCode']") private WebElement PostalCodeTextBox;
	@FindBy(xpath="//input[@name='continue']") private WebElement ContinueBtn;
	//Constructor
	public CheckOutPage1()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyURLOfCheckOutPage1()
	{
		return driver.getCurrentUrl();
	}
	public String verifyTitleOfApplication()
	{
		return titleOfCheckOutPage.getText();
	}
	public String Inputinformation()
	{
		FirstNameTextBox.sendKeys("vishvesh");
		LastNameTextBox.sendKeys("patil");
		PostalCodeTextBox.sendKeys("415409");
		ContinueBtn.click();
		return driver.getCurrentUrl();
	}
}