package userDefinedLibraries;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class DriverSetup {

	  
	  public static WebDriver driver;
	  public static String exePath;
	  public static String url = "https://www.urbanladder.com/";
	  public static String browsertype;
	  
	  public static WebDriver driverInstantiate(String browser) {
	    
	    // Declaration and instantiation of objects/variables
	    browsertype= browser;
	    if(browsertype.equalsIgnoreCase("chrome")) {
	      
	      exePath = "E:\\Softwares\\Selenium\\chromedriver\\chromedriver.exe";
	      ChromeOptions options=new ChromeOptions();
	      options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
	      System.setProperty("webdriver.chrome.driver", exePath);
	      driver = new ChromeDriver();                          
	      }
	    else if(browser.equalsIgnoreCase("opera")) {
	      
	      exePath = "E:\\Softwares\\Selenium\\operadriver\\operadriver.exe";
	      OperaOptions options=new OperaOptions();
	      options.setBinary("C:\\Users\\user\\AppData\\Local\\Programs\\Opera\\opera.exe");
	      System.setProperty("webdriver.opera.driver", exePath);
	      driver = new OperaDriver();                          
	      }  
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    // Launch browsers and direct it to the Base URL
	    driver.get(url);
	    driver.manage().deleteAllCookies();
	    return driver;    
	  }  
	  
	  public static void driverClose() {
	    
	    DriverSetup.driver.close();     
	    
	  }

}