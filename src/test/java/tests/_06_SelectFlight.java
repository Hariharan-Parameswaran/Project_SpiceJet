package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FlightBookingPages;
import pages.HomePages;

public class _06_SelectFlight {

	WebDriver driver;

	@BeforeClass()
	public void goToWebsite() {
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 6)
	public void selectFlight() {
		HomePages hPage = new HomePages(driver);
		hPage.oneWayTrip("mum", "del");

		FlightBookingPages fbPage = new FlightBookingPages(driver);
		fbPage.goToBooking();
	}

	@AfterClass
	public void afterC() {
		driver.quit();
	}
}
