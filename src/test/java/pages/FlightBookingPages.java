package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightBookingPages {

	@FindBy(css = "div[class='css-1dbjc4n r-1awozwy r-1xfd6ze r-1loqt21 r-18u37iz r-1777fci r-1w50u8q r-ah5dr5 r-1otgn73']")
	WebElement ContinueButton;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement firstName;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement lastName;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement mobileNumber;

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement email;

	@FindBy(xpath = "//div[text()='I am flying as the primary passenger']")
	WebElement checkBoxButton;

	@FindBy(xpath = "//div[@data-testid='traveller-info-continue-cta']")
	WebElement conButton;

	@FindBy(xpath = "(//div[@data-testid='add-ons-continue-footer-button'])[3]")
	WebElement continueButton2;

	WebDriver driver;

	public FlightBookingPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToBooking() {
		ContinueButton.click();
	}

	public void bookingDetail(String fname, String lName, String number, String em) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lName);
		mobileNumber.sendKeys(number);
		email.sendKeys(em);
		checkBoxButton.click();
		conButton.click();
		continueButton2.click();
	}
}
