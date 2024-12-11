package comc.automationpractice.interview;

import java.text.DateFormatSymbols;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumCalender {
	static String calenderDate = "06/15/2027";
	static String[] dateSplit = calenderDate.split("/");
	static String month = dateSplit[0];
	String day = dateSplit[1];
	static String year = dateSplit[2];

	public static boolean isYearInrange(Integer year, Integer startYear, Integer endYear) {

		return year >= startYear && year <= endYear;
	}

	public static void main(String[] args) {

		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.className("react-date-picker__calendar-button__icon")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		driver.findElement(By.className("react-calendar__navigation__label")).click();
		String yearRange = driver.findElement(By.className("react-calendar__navigation__label__labelText")).getText();
		String[] split = yearRange.split(" – ");
		if (isYearInrange(Integer.valueOf(year), Integer.valueOf(split[0]), Integer.valueOf(split[1]))) {
			List<WebElement> years = driver.findElements(By.className("react-calendar__decade-view__years__year"));
			for (WebElement calenderyear : years) {
				System.out.println(calenderyear.getText());
				if (calenderyear.getText().equals(year)) {
					calenderyear.click();
					break;
				}

			}
		}
		List<WebElement> calenderMonths = driver.findElements(
				By.xpath("//button[@class='react-calendar__tile react-calendar__year-view__months__month']/abbr"));
		for (WebElement calenderMonth : calenderMonths) {
			if (calenderMonth.getText().equals(getMonth(Integer.valueOf(month)))) {
				calenderMonth.click();
				break;
			}

		}
	}

	public static String getMonth(Integer month) {
		if (month < 1 || month > 12) {
			return "Invalid monthe";
		}
		String[] months = new DateFormatSymbols().getMonths();
		return months[month - 1];
	}

}
