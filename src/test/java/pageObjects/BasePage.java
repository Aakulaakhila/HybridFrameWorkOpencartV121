package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		/* PageFactory.initElements(driver,this); this line is Mandatory to use FindBy annotation, 
		 * we are using FindBy instead of using driver.findElements */
		
		
		
	}
	
}
