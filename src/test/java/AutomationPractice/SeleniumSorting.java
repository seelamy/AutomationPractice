package AutomationPractice;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumSorting {
	public static void main(String[] args) throws InterruptedException {
		WebDriver webDriver = new EdgeDriver();
		webDriver.get("https://www.amazon.in/");
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		webDriver.manage().window().maximize();
		webDriver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobiles");
		webDriver.findElement(By.id("nav-search-submit-button")).click();
		webDriver.findElement(By.xpath("//span[@data-action='a-dropdown-button']")).click();
		List<WebElement> dropDown = webDriver.findElements(By.xpath("//li/a[@class='a-dropdown-link']"));
		for (WebElement webElement : dropDown) {
			System.out.println(webElement.getText());
		}
		dropDown.stream().map(a -> a.getText()).forEach(System.out::println);
		webDriver.findElements(By.xpath("//li/a[@class='a-dropdown-link']")).stream()
				.filter(options -> options.getText().trim().equals("Price: High to Low")).findFirst()
				.ifPresent(WebElement::click);
		
		WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='a-price-whole']")));
		
		List<WebElement> mobilePrices = webDriver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		List<String> originalList = mobilePrices.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<String> sortedList = originalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(originalList.equals(sortedList));
	}

}
