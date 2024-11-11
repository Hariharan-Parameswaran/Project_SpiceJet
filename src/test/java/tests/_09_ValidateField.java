package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePages;

public class _09_ValidateField {

	WebDriver driver;

	@BeforeClass()
	public void goToWebsite() {
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 8)
	public void validateField() {
		HomePages hPage = new HomePages(driver);

		Assert.assertTrue(hPage.goToCheckIn(), "Check-in button is not working correctly");

		Assert.assertTrue(hPage.goToFlightStatus(), "Flight Status button is not working correctly");

		Assert.assertTrue(hPage.goToManageBooking(), "Manage Booking button is not working correctly");
	}

	@AfterClass
	public void afterC() {
		driver.quit();
	}
}
