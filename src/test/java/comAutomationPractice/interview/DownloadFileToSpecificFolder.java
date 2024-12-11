package comAutomationPractice.interview;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DownloadFileToSpecificFolder {
  public static void main(String[] args) {
	EdgeOptions edgeOptions=new EdgeOptions();
	Map<String,Object> prefs=new HashMap<String, Object>();
	prefs.put("download.default_directory", "C:\\Users\\yellareddy.seelam\\Downloads\\Automation\\AutomationPractice\\file");
	edgeOptions.setExperimentalOption("prefs", prefs);
	WebDriver driver=new EdgeDriver(edgeOptions);
	driver.get("https://examplefile.com/document/pdf/1-mb-pdf#google_vignette");
	driver.findElement(By.xpath("//a[@rel='nofollow']")).click();
}

}
