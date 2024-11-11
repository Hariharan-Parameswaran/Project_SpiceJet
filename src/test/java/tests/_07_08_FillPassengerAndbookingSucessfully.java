package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		try {
			HomePages hPage = new HomePages(driver);
			hPage.oneWayTrip("mum", "del");

			FlightBookingPages fbPage = new FlightBookingPages(driver);
			fbPage.goToBooking();
			fbPage.bookingDetail("hari", "P", "7871784765", "harifz7581@gmail.com");
			takeScreenshot("FillPassenger");
		} catch (Exception e) {
			takeScreenshot("FillPassengerfc");
			e.printStackTrace();
		}
	}

	public void takeScreenshot(String fileName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("screenshots/" + fileName + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterC() {
		driver.quit();
	}
}
