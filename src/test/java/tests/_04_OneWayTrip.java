package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		try {
			HomePages hPage = new HomePages(driver);
			hPage.oneWayTrip("mum", "del");

			String actualTitle = driver.getTitle();
			String expectedTitle = "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets";
			System.out.println(actualTitle);
			Assert.assertEquals(expectedTitle, actualTitle);
			takeScreenshot("oneWayTrip");
		} catch (Exception e) {
			takeScreenshot("oneWayTripfail");
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
