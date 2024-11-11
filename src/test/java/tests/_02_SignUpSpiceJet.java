package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePages;
import pages.SignUpPages;

public class _02_SignUpSpiceJet {

	WebDriver driver;

	@BeforeClass()
	public void goToWebsite() {
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 2)
	public void ValidateSignUpPage() {
		try {
			HomePages hPage = new HomePages(driver);
			hPage.goToSignUp();

			Set<String> windowHandles = driver.getWindowHandles();
			Iterator<String> iterator = windowHandles.iterator();

			String parentWindow = iterator.next();
			String signUpWindow = iterator.next();

			driver.switchTo().window(signUpWindow);

			SignUpPages signPage = new SignUpPages(driver);
			signPage.signuoDetails("hari", "PS", "05/12/1998", "7871784725", "harifz75811@gmail.com", "x56HxzWr2mq*ASV",
					"x56HxzWr2mq*ASV");

			takeScreenshot("SignUpSpiceJet");
			driver.switchTo().window(parentWindow);

		} catch (Exception e) {
			takeScreenshot("SignUpSpiceJetfail");
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
