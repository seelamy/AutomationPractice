package AutomationPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import AutomationPractice.pageObjects.LoginPage;
import AutomationPractice.pageObjects.ProductCatalogPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageOnly {
	public static void main(String[] args) {
		String productName="ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(chromeOptions);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPage loginPage=new LoginPage(driver);
		loginPage.goTo();
		loginPage.loginApplication("yellareddy.apple@gmail.com", "rahulshettyacademy");
		ProductCatalogPage productCatalogPage=new ProductCatalogPage(driver);
		List<WebElement> products=productCatalogPage.getProductList();
        productCatalogPage.addProductToCart(productName);
        
	    driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	    List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
	    Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equals(productName));
	    Assert.assertTrue(match);
	    driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
	    driver.findElement(By.xpath("//*[@placeholder='Select Country']")).sendKeys("India");
	   List<WebElement> countryDropDown= driver.findElements(By.className("ta-item"));
	   countryDropDown.stream().filter(country->country.getText().equals("India")).findFirst().get().click();
	   driver.findElement(By.className("action__submit")).click();
	   String confirmMessage= driver.findElement(By.className("hero-primary")).getText();
	   Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	   
	    
	}

}
