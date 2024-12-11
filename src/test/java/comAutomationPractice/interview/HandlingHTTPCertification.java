package comAutomationPractice.interview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

//EdgeOptions and ChromeOptions in Selenium are used to configure and customize the Microsoft Edge and Google Chrome browsers during test automation. 
//They allow you to set browser preferences, capabilities, and command-line arguments for controlling the browser behavior.

//options.addArguments("--headless");
//options.addArguments("--disable-notifications"); Prevent pop-up notifications that can interfere with automation.
//options.addArguments("--lang=en"); Set the default language of the browser.
//options.addArguments("--incognito"); Run the browser in incognito or private mode.
// options.addExtensions(new File("path/to/extension.crx")); Load custom extensions for testing. 
//options.addArguments("user-agent=CustomAgent/1.0"); Simulate a different user-agent.
//options.addArguments("--start-maximized"); Open the browser window maximized.
//options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation")); Remove “Chrome is being controlled by automated software” banner.
//Map<String, Object> prefs = new HashMap<>();prefs.put("download.default_directory", "C:\\Downloads"); options.setExperimentalOption("prefs", prefs);
//options.addArguments("--disable-popup-blocking"); Prevent popup windows.
//options.addArguments("--proxy-server=http://proxyserver:8080"); Configure a proxy for network traffic.
// edgeOptions.useChromium(true); // Required for IE mode
//edgeOptions.setCapability("ie.edgechromium", true); Enable compatibility mode for legacy applications.
//edgeOptions.setCapability("loggingPrefs", LogType.BROWSER); Set logging preferences for debugging.
public class HandlingHTTPCertification {
	public static void main(String[] args) {
		EdgeOptions edgeOptions=new EdgeOptions();
		edgeOptions.setAcceptInsecureCerts(true);
		WebDriver driver = new EdgeDriver(edgeOptions);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
	}

}
