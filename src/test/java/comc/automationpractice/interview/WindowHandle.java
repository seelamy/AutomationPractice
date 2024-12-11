package comc.automationpractice.interview;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandle {
	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windows= driver.getWindowHandles();
		 Iterator<String> iterator = windows.iterator();
		 String parent=iterator.next();
		 String child=iterator.next();
		 driver.switchTo().window(child);
		 System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		 
	}

}
