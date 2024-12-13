package AutomationPractice;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Pagination {
	static WebDriver driver;
	static Actions actions;

	public static void main(String[] args) {
		driver = new EdgeDriver();
		actions = new Actions(driver);
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		try {
			WebElement element = driver.findElement(By.xpath("//span[@class='_30XB9F']"));
			element.click();
		} catch (Exception e) {
			System.out.println("Login popup not dispalyed");
		}

		selectCategory("Fashion");
		selectSubMenuItem("Men's Bottom Wear");
		selectCustomerRating("4★ & above");
		selectPriceRange("250");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String totalFilterResults = driver.findElement(By.className("BT4kdg")).getText();
		int totalProductCount = extractNumber(totalFilterResults);
		int totalCount = getAllTheFilteredProductCount();
		Assert.assertEquals(totalProductCount, totalCount);

	}

	public static WebElement selectCategory(String category) {
		WebElement categoryElement = driver
				.findElement(By.xpath("//img[@alt='" + category + "']/ancestor::div[@class='YBLJE4']"));
		actionMoveToElement(categoryElement);
		return categoryElement;

	}

	public static void selectSubMenuItem(String subMenuItem) {
		List<WebElement> submenuItems = driver.findElements(By.xpath("//div[@class='_16rZTH']//a"));

		submenuItems.stream().filter(a -> a.getText().trim().equals(subMenuItem)).findFirst()
				.ifPresent(Pagination::actionMoveToElementAndClick);

	}

	public static void selectCustomerRating(String customerRating) {
		driver.findElement(By.xpath("//div[@title='" + customerRating + "']")).click();

	}

	public static void selectPriceRange(String price) {
		WebElement webElement = driver.findElement(By.xpath("//div[@class='tKgS7w']/select"));
		selectUtility(webElement, price);
	}

	public static int getAllTheFilteredProductCount() {
		int count = 0;
		while (true) {
			List<WebElement> products = driver.findElements(By.cssSelector("._1sdMkc.LFEi7Z"));

			count += products.size();
			List<WebElement> nextButton = driver.findElements(By.xpath("//span[text()='Next']"));
			if (nextButton.size() > 0 && nextButton.get(0).isDisplayed()) {
				nextButton.get(0).click();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				break;
			}
		}

		return count;

	}

	public static void actionMoveToElement(WebElement element) {
		actions.moveToElement(element).perform();

	}

	public static void actionMoveToElementAndClick(WebElement element) {
		actions.moveToElement(element).click().perform();

	}

	public static void selectUtility(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public static Integer extractNumber(String text) {
		String extractedNumber = Pattern.compile("\\d+").matcher(text).results().map(match -> match.group())
				.collect(Collectors.toList()).get(2);

		return Integer.valueOf(extractedNumber);

	}

}
