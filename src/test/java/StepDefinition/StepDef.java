package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.LoginPage;
import Utilities.ReadConfig;
import context.TestContextUI;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.TakesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.codehaus.plexus.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Factory.DriverFactory;

public class StepDef extends BaseClass{
	//WebDriver driver=null;
	//LoginPage loginpg=null;
	public static String browserName=null;
	Scenario sc;// for the custom massages ,screenshot . cucumber itself intialize
	//	it and injecting at setUp and we can assign it to our scenario object sc and this we can use only with 
	//@before @after
	TestContextUI testContextUI;
	WebDriver driver;
	Scenario scn;

	public StepDef(TestContextUI testContextUI) {
		this.testContextUI = testContextUI;
	}
	@Before
	public void setUp() {
		
		ReadConfig.getProperties();
		logger=LogManager.getLogger("StepDef");
		logger.info("Launch the browser");
		System.out.println("Set up of all sessions");

		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver = new DriverFactory().createInstance(browserName);		   
			
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			
			driver = new DriverFactory().createInstance(browserName);		   
			
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			
			driver = new DriverFactory().createInstance(browserName);		   
			
		}
		
		testContextUI.setDriverC(driver);
		testContextUI.intializePageObjects(driver);
	}
	@After
	public void tearDown(Scenario sc) {
		System.out.println("Tear down of all sessions");
		if(sc.isFailed()==true) {
			String filePath= ".//Screenshot/img.png";
			TakesScreenshot screenshot= (TakesScreenshot)testContextUI.getDriverC();
			File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
			File destFile= new File(filePath);
			try {
				FileUtils.copyFile(srcFile, destFile);
				logger.warn("Takes failed screenshot");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		testContextUI.getDriverC().quit();
		logger.info("close the browser");

	}
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {


		System.out.println("Launch browser");

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {		
		testContextUI.getDriverC().get(url);
		testContextUI.getDriverC().manage().window().maximize() ;
	}

	@SuppressWarnings("deprecation")
	@When("^User enters Email as \"(.*)\" and Password as \"(.*)\"$")
	public void user_enters_email_as_and_password_as(String email, String pwd) throws InterruptedException {

		//loginpg.enterEmail(email);
		testContextUI.getLoginpage().enterEmail(email);
		testContextUI.getDriverC().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		testContextUI.getLoginpage().enterPassword(pwd);

	}

	@When("Click on Login")
	public void click_on_login() {
		testContextUI.getLoginpage().clickOnLoginBtn();
		testContextUI.getDriverC().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	}
	////////////////////LOGIN FEATURE////////////////////////
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle= testContextUI.getDriverC().getTitle();
		assertEquals(actualTitle,expectedTitle);

	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		testContextUI.getLoginpage().clickOnLogoutBtn();
	}

	@Then("close browser")
	public void close_browser() {
		testContextUI.getDriverC().close();

	}
	////////////////////////////// ADD NEW CUSTOMER //////////////////////////
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle = testContextUI.getCustomerPage().getPageTitle();
		String expectedTilte= "Dashboard / nopCommerce administration";
		Assert.assertEquals(actualTitle, expectedTilte);
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		testContextUI.getCustomerPage().clickOnCustomersMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		testContextUI.getCustomerPage().clickOnCustomersMenuItem();
		testContextUI.getDriverC().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		testContextUI.getCustomerPage().clickOnAddnew();
		testContextUI.getDriverC().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String expectedTitle="Add a new customer / nopCommerce administration";
		String actualTitle=testContextUI.getDriverC().getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		testContextUI.getCustomerPage().enterEmail(getRandomEmail()+"@gmail.com");
		testContextUI.getDriverC().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		testContextUI.getCustomerPage().enterPassword("test2");
		testContextUI.getDriverC().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		testContextUI.getCustomerPage().enterFirstName("ms");
		testContextUI.getDriverC().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		testContextUI.getCustomerPage().enterLastName("dhoni");
		testContextUI.getDriverC().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		testContextUI.getCustomerPage().enterGender("male");
		testContextUI.getDriverC().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		testContextUI.getCustomerPage().enterDob("8/19/1991");
		testContextUI.getDriverC().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		testContextUI.getCustomerPage().enterCompanyName("test");
		testContextUI.getDriverC().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		//		testContextUI.getCustomerPage().enterNewsLetter();
		//		testContextUI.getDriverC().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		//		testContextUI.getCustomerPage().enterCustomerRoles("Registered");
		//		testContextUI.getDriverC().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		testContextUI.getCustomerPage().enterManagerOfVendor("Vendor 1");
		testContextUI.getDriverC().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		testContextUI.getCustomerPage().enterAdminContent("This is the third customer");
		testContextUI.getDriverC().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		logger.info("Customer Registered");

	}

	@When("click on Save button")
	public void click_on_save_button() {
		testContextUI.getCustomerPage().clickOnSave();
		testContextUI.getDriverC().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedTitle) {
		String bodyText= testContextUI.getDriverC().findElement(By.tagName("Body")).getText();
		if(bodyText.contains(expectedTitle)) {
			Assert.assertTrue(true); //pass
		}
		else {
			Assert.assertTrue(false);
		}
	}
	////////////////////////////////////SERACH BY EMAIL///////////////////////
	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
		testContextUI.getSearchPage().enterEmailAdd("victoria_victoria@nopCommerce.com");		

	}
	@When("Click on search button")
	public void click_on_search_button() {
		testContextUI.getSearchPage().clickOnSearchButton();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedEmail = "victoria_victoria@nopCommerce.com";

		//   Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail));

		if( testContextUI.getSearchPage().searchCustomerByEmail(expectedEmail) ==true)
		{
			Assert.assertTrue(true);
			//log.info("User should found Email in the Search table - passed");

		}
		else {
			//log.info("User should found Email in the Search table - passed");
			Assert.assertTrue(false);

		}
	}
	///////////////search customer by name////////////////////


	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		testContextUI.getSearchPage().enterFirstName("lal");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		testContextUI.getSearchPage().enterLastName("chadda");

	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName = "Lal chadda";


		if( testContextUI.getSearchPage().searchCustomerByName(expectedName) ==true)
		{
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);

	}

}
