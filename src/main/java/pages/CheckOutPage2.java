package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutPage2 extends TestBase
{
	//object repository
		@FindBy(xpath="//span[@class='title']") private WebElement CheckOutPage2Lable;
		@FindBy(xpath="(//div[@class='summary_info_label'])[1]") private WebElement PaymentInfoText;
		@FindBy(xpath="(//div[@class='summary_info_label'])[2]") private WebElement ShippingInfoText;
		@FindBy(xpath="(//div[@class='summary_info_label'])[3]") private WebElement itemTotalText;
		@FindBy(xpath="//div[@class='summary_info_label summary_total_label']") private WebElement TotalText;
		@FindBy(xpath="//button[@class='btn btn_secondary back btn_medium cart_cancel_link']") private WebElement CancelBtn;
		@FindBy(xpath=" //button[@class='btn btn_action btn_medium cart_button']") private WebElement FinishBtn;
		 public CheckOutPage2()
		 {
			 PageFactory.initElements(driver,this);
		 }
		 public String verifyLable()
		 {
			 return CheckOutPage2Lable.getText();
		 }
		 public String verifyPaymentInfoText()
		 {
			 return PaymentInfoText.getText();
		 }
		 public String verifyShippingInfoText()
		 {
			 return ShippingInfoText.getText();
		 }
		 public String verifyitemTotalText()
		 {
			 return itemTotalText.getText();
		 }
		 public String verifyTotalText()
		 {
			 return TotalText.getText();
		 }
		 public String clickOnFinishBtn()
		 {
			 FinishBtn.click();
			 return driver.getCurrentUrl();
		 }
		 public String clickOnCancelBtn()
		 {
			 CancelBtn.click();
			 return driver.getCurrentUrl();
		 }		
}