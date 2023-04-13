package AutomationPractice.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationPractice.AbstractComponents.AbstractComponents;


public class LoginPage extends AbstractComponents {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(xpath = "//input[@name='login']")
	WebElement submit;
	
	public void loginApplication(String userName,String password) {
		userEmail.sendKeys(userName);
		userPassword.sendKeys(password);
		submit.click();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	    driver.manage().window().maximize();

	}

}
