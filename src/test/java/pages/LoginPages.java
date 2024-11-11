package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPages {

	@FindBy(xpath = "//div[text()='Email']")
	WebElement emailRadioButton;

	@FindBy(xpath = "//input[@type='email']")
	WebElement enmailContent;

	@FindBy(xpath = "//input[@type='password']")
	WebElement pswd;

	@FindBy(xpath = "//div[@class='css-1dbjc4n r-1awozwy r-184aecr r-z2wwpe r-1loqt21 r-18u37iz r-tmtnm0 r-1777fci r-1x0uki6 r-1w50u8q r-ah5dr5 r-1otgn73']")
	WebElement loginButton;

	WebDriver driver;

	public LoginPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginDetails(String email, String pwds) {
		emailRadioButton.click();
		enmailContent.sendKeys(email);
		pswd.sendKeys(pwds);
		loginButton.click();
	}

}
