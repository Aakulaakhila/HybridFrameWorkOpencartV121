package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement txtFirstname;

	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement txtlastName;

	@FindBy(xpath="//input[@placeholder='E-Mail']")
	WebElement txtEmail;

	@FindBy(xpath="//input[@placeholder='Telephone']")
	WebElement txtPhoneNum ;

	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement txtPassword ;

	@FindBy(xpath="//input[@placeholder='Password Confirm']")
	WebElement txtPasswordConfirm ;

	@FindBy(xpath="//input[@name='agree']")
	WebElement chkPolicy ;

	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	//creating actionmethods for above mentioned Locators

	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}

	public void setLastName(String lname)
	{
		txtlastName.sendKeys(lname);
	}

	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}

	public void setPhoneNum(String phoneNum)
	{
		txtPhoneNum.sendKeys(phoneNum);
	}

	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}

	public void setConfirmPswd(String confPswd)
	{
		txtPasswordConfirm.sendKeys(confPswd);
	}

	public void checkPolicy()
	{
		chkPolicy.click();
	}

	public void clickContinue()
	{
		btnContinue.click();
	}

	public String getConfirmationMsg() 
	{
		try {
			return (msgConfirmation.getText());
		} 
		catch (Exception e) {
			return (e.getMessage());
		}

	}
}
