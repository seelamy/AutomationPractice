package AutomationPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import AutomationPractice.pageObjects.CartPage;
import AutomationPractice.pageObjects.CheckOutPage;
import AutomationPractice.pageObjects.ConfirmationPage;
import AutomationPractice.pageObjects.LoginPage;
import AutomationPractice.pageObjects.ProductCatalogPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageOnly {
	public static void main(String[] args) {

		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		LoginPage loginPage = new LoginPage(driver);
		loginPage.goTo();

		ProductCatalogPage productCatalogPage = loginPage.loginApplication("yellareddy.apple@gmail.com",
				"rahulshettyacademy");
		List<WebElement> products = productCatalogPage.getProductList();
		productCatalogPage.addProductToCart(productName);

		CartPage cartPage = productCatalogPage.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkOutPage = cartPage.goToCheckOut();

		checkOutPage.sendCountry("India");
		checkOutPage.selectCountryFromDropDown("India");
		ConfirmationPage confirmationPage = checkOutPage.checkOutPageSubmit();

		Assert.assertTrue(confirmationPage.confirmationMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}

}
