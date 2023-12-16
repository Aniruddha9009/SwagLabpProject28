package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ExtentReportManager;
import utility.ReadData;

public class TestBase 
{
	public ExtentReports report=ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	public static WebDriver driver;
	public void initialization() throws InterruptedException, IOException 
	{
	    String browser=ReadData.readPropertyFile("browser");
	    if(browser.equals("chrome"))
	    {
	    	WebDriverManager.chromedriver().setup();
	    	driver = new ChromeDriver();
	    }
	    else if(browser.equals("firefox"))
	    {
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    }
	    else if(browser.equals("edge"))
	    {
	    	WebDriverManager.edgedriver().setup();
	    	driver=new EdgeDriver();	
	    }
	    driver.manage().window().maximize();
	    driver.get(ReadData.readPropertyFile("URL"));
	    driver.manage().deleteAllCookies();
	    Thread.sleep(1000);
	}
}