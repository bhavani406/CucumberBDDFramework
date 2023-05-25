package context;

import org.openqa.selenium.WebDriver;
import PageObject.*;

public class TestContextUI {
	WebDriver driverC;
	LoginPage loginpage;
	NewCustomerPage customerPage;
	SearchCustomerPage searchPage;

	
	public WebDriver getDriverC() {
		return driverC;
	}
	public void setDriverC(WebDriver driverC) {
		this.driverC = driverC;
	}
	public LoginPage getLoginpage() {
		return loginpage;
	}
	public NewCustomerPage getCustomerPage() {
		return customerPage;
	}
	public SearchCustomerPage getSearchPage() {
		return searchPage;
	}
	public void intializePageObjects(WebDriver driver) {
		loginpage= new LoginPage(driver);
		customerPage= new NewCustomerPage(driver);
		searchPage= new SearchCustomerPage(driver);
	}


}
