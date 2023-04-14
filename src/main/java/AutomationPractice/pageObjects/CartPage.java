package AutomationPractice.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationPractice.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".totalRow button")
	WebElement checkOut;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;

	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equals(productName));
		return match;

	}

	public CheckOutPage goToCheckOut() {
		checkOut.click();
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		return checkOutPage;

	}

}
