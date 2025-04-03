package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


		public class BaseClass {
	public WebDriver driver; 

	public Logger logger; //log4j
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	
	{
		//Loading config.properties file
		FileReader file= new FileReader(".\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);
		
		
		logger = LogManager.getLogger(this.getClass()); //log4j2
		
		switch(br.toLowerCase()) //this is bcs we give some times uppercase
		{
		case "chrome" : 
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver=new ChromeDriver(options);break; */
			driver=new ChromeDriver();break;
		case "edge": driver=new EdgeDriver();break;
		case "firefox": driver=new FirefoxDriver();break;
		default :	System.out.println("Invalid browser name...");return;
		}
		//headles
		/* System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

	        // Set ChromeOptions for Headless mode
		 ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new"); 
			
			// This is key for headless mode
	       for this we have to comment driver=new ChromeDriver(otpions);  */ 
		//headles
		
		
		
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appURL2")); //reading url from properties file
		driver.manage().window().maximize();

	}

	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void teardown()
	{
		driver.close();
	}

	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber()
	{
		String generatedNumber = RandomStringUtils.randomNumeric(10);
		return generatedNumber;
	}

	public String randomAlphaNumeric()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		String generatedNumber = RandomStringUtils.randomNumeric(4);
		return (generatedString+"@"+generatedNumber);
	}

	
}
