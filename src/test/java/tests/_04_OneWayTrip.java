package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePages;

public class _04_OneWayTrip {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass()
	public void goToWebsite() {
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 4)
	public void oneWay() {
		HomePages hPage = new HomePages(driver);
		hPage.oneWayTrip("mum", "del");

		String actualTitle = driver.getTitle();
		String expectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		System.out.println(actualTitle);
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@AfterClass
	public void afterC() {
		driver.quit();
	}

}
