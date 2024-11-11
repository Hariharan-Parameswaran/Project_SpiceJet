package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPages {

	@FindBy(xpath = "//select[@class='form-control form-select ']")
	WebElement selectTitle;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement fname;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lname;

	@FindBy(xpath = "//input[@id='dobDate']")
	WebElement dobDate;

	@FindBy(xpath = "//input[@placeholder='+91 01234 56789']")
	WebElement mobnumber;

	@FindBy(id = "email_id")
	WebElement email;

	@FindBy(xpath = "//input[@id='new-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='c-password']")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@id='defaultCheck1']")
	WebElement checkbox;

	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitButton;

	WebDriver driver;

	public SignUpPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void signuoDetails(String name, String lastName, String DOB, String phNumber, String emaddress, String pswd,
			String cpswd) {

		Select titleDropdown = new Select(selectTitle);
		titleDropdown.selectByVisibleText("Mr");
		fname.sendKeys(name);
		lname.sendKeys(lastName);
		dobDate.sendKeys(DOB);
		mobnumber.sendKeys(phNumber);
		email.sendKeys(emaddress);
		password.sendKeys(pswd);
		confirmPassword.sendKeys(cpswd);
		checkbox.click();
		submitButton.click();
	}
}
