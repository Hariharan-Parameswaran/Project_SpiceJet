package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePages {

	@FindBy(xpath = "//div[text()='Signup']")
	WebElement signUpButton;

	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginButton;

	@FindBy(xpath = "//div[contains(text(),'one way')]")
	WebElement oneWayButton;

	@FindBy(xpath = "//div[@data-testid='to-testID-origin']//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']")
	WebElement startLocation;

	@FindBy(xpath = "//div[@data-testid='to-testID-origin']//input[@type='text']")
	WebElement slocation;

	@FindBy(xpath = "//div[@data-testid='to-testID-destination']//input[@type='text']")
	WebElement endLocation;

	@FindBy(xpath = "//div[text()='Sardar Vallabhbhai Patel International Airport']")
	WebElement eLocation;

	@FindBy(xpath = "//div[text()='Departure Date']")
	WebElement departDate;

	@FindBy(xpath = "//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")
	WebElement selectDate;

	@FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/div[2]/div[2]/div[3]/div[2]/div[1]/div[1]/div[1]/div[3]/div[4]/div[4]/div[1]/div[1]")
	WebElement selDate;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73']")
	WebElement searchButton;

	@FindBy(xpath = "//div[contains(text(),'round trip')]")
	WebElement roundTripButton;

	@FindBy(xpath = "//div[text()='Return Date']")
	WebElement returnData;

	@FindBy(xpath = "//div[text()='Select Date']")
	WebElement selectData;

	@FindBy(xpath = "(//div[@class='css-1dbjc4n r-1mdbw0j r-ymttw5 r-b2dl2 r-mzjzbw r-wk8lta r-tvv088']//div[1]//div[1]//div[1]//div[1]")
	WebElement retData;

	@FindBy(xpath = "//div[text()='check-in']")
	WebElement checkInButton;

	@FindBy(xpath = "//div[text()='flight status']")
	WebElement flightStatusButton;

	@FindBy(xpath = "//div[text()='manage booking']")
	WebElement manageBookingButton;

	WebDriver driver;

	public HomePages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToSignUp() {
		signUpButton.click();
	}

	public void goToLogin() {
		loginButton.click();
	}

	public void oneWayTrip(String start, String end) {
		oneWayButton.click();
		startLocation.click();
		slocation.sendKeys(start);
		endLocation.sendKeys(end);
		selDate.click();
		searchButton.click();
	}

	public void roundTripDetail(String start, String end) {
		roundTripButton.click();
		startLocation.click();
		slocation.sendKeys(start);
		endLocation.sendKeys(end);
		selDate.click();
		returnData.click();
		selectData.click();
		selDate.click();
		searchButton.click();
	}

	public boolean goToCheckIn() {
		try {
			if (checkInButton.isDisplayed() && checkInButton.isEnabled()) {
				checkInButton.click();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean goToFlightStatus() {
		try {
			if (flightStatusButton.isDisplayed() && flightStatusButton.isEnabled()) {
				flightStatusButton.click();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean goToManageBooking() {
		try {
			if (manageBookingButton.isDisplayed() && manageBookingButton.isEnabled()) {
				manageBookingButton.click();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
