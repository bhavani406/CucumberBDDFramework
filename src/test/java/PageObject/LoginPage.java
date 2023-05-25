package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver lDriver;

	public LoginPage(WebDriver rDriver) {
		super();
		lDriver = rDriver;
		PageFactory.initElements(lDriver, this);
	}

	@FindBy(id = "Email")
	WebElement email;
	@FindBy(xpath = "//input[@id='Password']")
	WebElement password;
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement loginBtn;
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logoutBtn;

	public void enterEmail(String emailAdd) {
		email.clear();
		email.sendKeys(emailAdd);
	}

	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}

	public void clickOnLoginBtn() {
		loginBtn.click();
	}

	public void clickOnLogoutBtn() {
		logoutBtn.click();
	}

}
