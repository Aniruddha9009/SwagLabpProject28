package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdownList 
{
	public static void handleselectclass(WebElement ele,String value) 
	{
		Select sc=new Select(ele);
		sc.selectByVisibleText(value);
	}
	
}
 