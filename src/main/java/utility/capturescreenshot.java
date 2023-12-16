package utility;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class capturescreenshot extends TestBase
{
	public static String getDate()
	{
		return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date(0));
	}
	public static void screenshot(String nameofMethod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\hp\\eclipse-workspace\\selenium_28_batch\\screenshot\\"+nameofMethod+"--"+getDate()+".jpeg");
		FileHandler.copy(source, dest);
	}
}
