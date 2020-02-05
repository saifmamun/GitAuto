package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utils.WebDriverFunctions;

public class configuration extends WebDriverFunctions {
	
	@Parameters({"url", "browser"})// this annotation is used to insert browser parameter from TestNG xml
	@BeforeMethod
	public  void browserInitialize(String url, String browsername){
		APPLICATION_LOGS.info ("Browser STARTED");
		if(driver == null){
			if(browsername.equalsIgnoreCase("Chrome")){
			
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				// for chrome browser maximizing code
				chromeOptions.addArguments("--start-maximized");
				//Create an instance of WebDriver interface by passing parameter
				driver = new ChromeDriver(chromeOptions);
			}
		else if(browsername.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver", 
				System.getProperty("user.dir") + "//drivers//geckodriver.exe");
				driver = new FirefoxDriver();
				maxPage();
		}
		else
	        {
				throw new IllegalArgumentException("The Browser Type is Undefined");
	        }

		}
		APPLICATION_LOGS.info("Browser MAXIMIZE");
		driver.get(url);
		APPLICATION_LOGS.info ("www.facebook.com opened");
	}
	
	//@AfterMethod
	public void afterTest (){
		System.out.println("Close the browser");
		APPLICATION_LOGS.info ("Browser got closed");
		driver.close();
	}
	
}
		
		
			