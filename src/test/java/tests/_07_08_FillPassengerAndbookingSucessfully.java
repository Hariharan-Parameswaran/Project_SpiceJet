package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FlightBookingPages;
import pages.HomePages;

public class _07_08_FillPassengerAndbookingSucessfully {

	WebDriver driver;

	@BeforeClass()
	public void goToWebsite() {
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 7)
	public void bookingForm() {
		HomePages hPage = new HomePages(driver);
		hPage.oneWayTrip("mum", "del");

		FlightBookingPages fbPage = new FlightBookingPages(driver);
		fbPage.goToBooking();
		fbPage.bookingDetail("hari", "P", "7871784765", "harifz7581@gmail.com");
	}

	@AfterClass
	public void afterC() {
		driver.quit();
	}
}
