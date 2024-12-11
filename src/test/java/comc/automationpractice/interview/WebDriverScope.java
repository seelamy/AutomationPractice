package comc.automationpractice.interview;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;//h2[text()='Popular with travelers from India']
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverScope {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.booking.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		WebElement webElement = driver
				.findElement(By.xpath("//div[@aria-labelledby='mainIndexInterlinkingTab-1-tab-trigger']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView();", webElement);
		List<WebElement> links = webElement.findElements(By.tagName("a"));
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driverWait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@aria-labelledby='mainIndexInterlinkingTab-1-tab-trigger']//a")));
//		for (WebElement link : links) {
//			System.out.println(link.getAttribute("href"));
//			String linkURL = link.getAttribute("href");
//			verfiyLink(linkURL);
//		}

		for (int i = 0; i < 5; i++) {
			String clickLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			driver.findElements(By.xpath("//div[@aria-labelledby='mainIndexInterlinkingTab-1-tab-trigger']//a")).get(i)
					.sendKeys(clickLink);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}

		driver.quit();
	}

	public static void verfiyLink(String link) {
		try {
			URL url = new URL(link);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(5000);
			connection.connect();
			System.out.println(connection.getResponseCode());
			if (connection.getResponseCode() == 200) {
				System.out.println(url + " - " + connection.getResponseMessage());
			} else {
				System.out.println(url + " - " + "Is a broken url link");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
