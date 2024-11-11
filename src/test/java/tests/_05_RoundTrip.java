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

public class _05_RoundTrip {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass()
	public void goToWebsite() {
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 5)
	public void roundTrip() {
		HomePages hPage = new HomePages(driver);
		hPage.roundTripDetail("mum", "del");

		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@AfterClass
	public void afterC() {
		driver.quit();
	}
}
