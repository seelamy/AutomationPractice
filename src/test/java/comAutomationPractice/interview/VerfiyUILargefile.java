package comAutomationPractice.interview;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class VerfiyUILargefile {
	public static void main(String[] args) throws AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yellareddy.seelam\\Downloads\\Automation\\AutomationPractice\\drivers\\chromedriver.exe");

		System.setProperty("webdriver.http.factory", "jdk-http-client");
//		ChromeOptions chromeOptions=new ChromeOptions();
//		chromeOptions.addArguments("--remote-allow-origins=*");
//		chromeOptions.addArguments("--no-sandbox");
//		chromeOptions.addArguments("--disable-dev-shm-usage");
//		chromeOptions.addArguments("--headless");
//		chromeOptions.addArguments("--disable-gpu");
//        chromeOptions.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		WebDriver webDriver=new EdgeDriver();
		webDriver.get("https://filebin.net/");
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement hiddenInput= webDriver.findElement(By.id("fileField"));
		Actions actions=new Actions(webDriver);
		actions.moveToElement(hiddenInput).perform();
//		 JavascriptExecutor js = (JavascriptExecutor) webDriver;
//	        js.executeScript("arguments[0].style.display='block';", hiddenInput);
//	        hiddenInput.sendKeys("C:\\Users\\yellareddy.seelam\\Downloads\\Automation\\AutomationPractice\\files\\200MB-TESTFILE.ORG.pdf"); 
	        
	    webDriver.findElement(By.id("fileField")).sendKeys("C:/Users/yellareddy.seelam/Downloads/Automation/AutomationPractice/files/200MB-TESTFILE.ORG.pdf");
	}
	

}
