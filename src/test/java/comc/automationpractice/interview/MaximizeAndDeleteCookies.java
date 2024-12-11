package comc.automationpractice.interview;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;


public class MaximizeAndDeleteCookies {
	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String loginSuccess=driver.findElement(By.xpath("//div[@id='flash-messages']/div")).getText();
		System.out.println(loginSuccess);
		
		// Will have all the cookies info
		Set<Cookie> getAllCookies = driver.manage().getCookies();
		for (Cookie cookie : getAllCookies) {
			System.out.println(cookie.toString());
		}
		
		// rack.session is the cookie  which maintain the session information and if we delete this session user Successfully redirected to the login page
		
		System.out.println(driver.manage().getCookieNamed("rack.session"));
		
		driver.manage().deleteCookieNamed("rack.session");
		System.out.println(driver.manage().getCookieNamed("rack.session"));
		
		// to see if the session cookie deleted successfully we need to refresh the page
		driver.navigate().refresh();
		String logoutSuccess=driver.findElement(By.xpath("//div[@id='flash-messages']/div")).getText();
		System.out.println(logoutSuccess);
		Assert.assertEquals("You must login to view the secure area! ", logoutSuccess);
		
	}

}
