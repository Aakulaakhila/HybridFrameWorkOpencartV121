package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//in pom first declare a constructor, next locate elements, after that create action methods for each locator.
public class HomePage extends BasePage{

	WebDriver driver;

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	@FindBy(xpath=("//span[normalize-space()='My Account']"))
			WebElement myaccountLnk;

	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement registerLink;

	//@FindBy(linkText="Login")  
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement loginLink; //loginLink added in step 5

	//Action methods

	public void clickMyAccount()
	{
		myaccountLnk.click();
	}

	public void clickRegister()
	{
		registerLink.click();
	}
	
	public void clickLogin()
	{
		loginLink.click();
	}
}
