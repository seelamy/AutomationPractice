package AutomationPractice.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationPractice.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {

	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[@placeholder='Select Country']")
	WebElement country;

	@FindBy(css = ".ta-item")
	List<WebElement> countryDropDownValues;

	@FindBy(css = ".action__submit")
	WebElement submit;

	public void sendCountry(String countryName) {
		country.sendKeys(countryName);
	}

	public void selectCountryFromDropDown(String countryName) {
		countryDropDownValues.stream().filter(country -> country.getText().equals(countryName)).findFirst().get()
				.click();

	}

	public ConfirmationPage checkOutPageSubmit() {
		submit.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);

		return confirmationPage;
	}

}
