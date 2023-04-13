package AutomationPractice.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	WebDriver  driver;
	WebDriverWait driverWait;
	
	public AbstractComponents(WebDriver driver) {
		this.driver=driver;
		
	}

	public void waitForElementToAppear(By findBy) {
		driverWait =new WebDriverWait(driver, Duration.ofSeconds(5));
	    driverWait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	
	public void waitForElementToDisappear(WebElement ele) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//driverWait.until(ExpectedConditions.invisibilityOf(ele));
		}


}
