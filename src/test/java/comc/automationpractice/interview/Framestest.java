package comc.automationpractice.interview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Framestest {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		List<WebElement> numberOfFrames = driver.findElements(By.tagName("iframe"));
		driver.switchTo().frame(numberOfFrames.get(0));
		driver.switchTo().defaultContent();
	}
	//

}
