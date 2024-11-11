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
		try {
		HomePages hPage = new HomePages(driver);
		hPage.oneWayTrip("mum", "del");

		FlightBookingPages fbPage = new FlightBookingPages(driver);
		fbPage.goToBooking();
		takeScreenshot("selectFlight");
	} catch (Exception e) {
		takeScreenshot("selectFlightfc");
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
