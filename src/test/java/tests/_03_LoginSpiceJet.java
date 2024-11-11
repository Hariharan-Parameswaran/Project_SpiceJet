package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePages;
import pages.LoginPages;

public class _03_LoginSpiceJet {

	WebDriver driver;

	@BeforeClass()
	public void goToWebsite() {
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 3)
	public void navigateLoginPage() {
		HomePages hPage = new HomePages(driver);
		hPage.goToLogin();

		LoginPages lPage = new LoginPages(driver);
		lPage.loginDetails("harifz7581@gmail.com", "harifz_7581");

	}

	@AfterClass
	public void afterC() {
		driver.quit();
	}
}
