package comAutomationPractice.interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AutoSuggestion {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("India");

		selectCountry("British Indian Ocean Territory");
	}

	public static void selectCountry(String country) {
		List<WebElement> countryList = driver.findElements(By.xpath("//li[@class='ui-menu-item']/div"));
		for (WebElement countryElement : countryList) {
			if(countryElement.getText().equals(country)) {
				countryElement.click();
			}
			break;
		}
	}

}
