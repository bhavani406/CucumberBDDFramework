package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

public class NewCustomerPage {
	WebDriver ldriver;
	public NewCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		
	}
	//Find web elements on the web page
		@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]") 
		WebElement lnkCustomers_menu;
		@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]") 
		WebElement lnkCustomers_menuitem;
		@FindBy(xpath = "//a[@class='btn btn-primary']") 
		WebElement btnAddnew;
		@FindBy(xpath = "//input[@id='Email']")
		WebElement txtEmail;
		@FindBy(xpath = "//input[@id='Password']")
		WebElement txtPassword;
		@FindBy(xpath = "//input[@id='FirstName']")
		WebElement txtFirstName;
		@FindBy(xpath = "//input[@id='LastName']")
		WebElement txtLastName;
		@FindBy(id = "Gender_Male")
		WebElement MaleGender;
		@FindBy(id = "Gender_Female")
		WebElement FeMaleGender;
		@FindBy(xpath = "//input[@id='DateOfBirth']")
		WebElement txtDob;
		@FindBy(xpath = "//input[@id='Company']")
		WebElement txtCompanyName;
		@FindBy(xpath = "//*[@id='VendorId']")
		WebElement dropdownVendorMgr;
		@FindBy(xpath = "//li[contains(text(),'Administrators')]")
		WebElement listItemAdministrators;
		@FindBy(xpath = "//li[contains(text(),'Registered')]")
		WebElement listItemRegistered;
		@FindBy(xpath = "//li[contains(text(),'Guests')]")
		WebElement listItemGuests;
		@FindBy(xpath = "//li[contains(text(),'Vendors')]")
		WebElement listItemVendors;
		@FindBy(xpath = "//textarea[@id='AdminComment']")
		WebElement txtAdminContent;
		@FindBy(xpath = "//button[@name='save']")
		WebElement btnSave;
		@FindBy(xpath = "//div[@class='card-body']/div[9]/div[2]/descendant::div[@class='k-multiselect-wrap k-floatwrap']")
		WebElement txtNewsLetter;
		@FindBy(xpath = "//select[@id='SelectedNewsletterSubscriptionStoreIds']")
		WebElement selectNewsLetter;
		@FindBy(xpath = "//div[@class='card-body']/div[10]/div[2]/descendant::div[@class='k-multiselect-wrap k-floatwrap']")
		WebElement txtCustomerRoles;
		//Actions Methods for web elements

		public String getPageTitle()
		{
			return ldriver.getTitle();
		}
		public void clickOnCustomersMenu() {
			lnkCustomers_menu.click();
		}
		public void clickOnCustomersMenuItem() {
			lnkCustomers_menuitem.click();
		}
		public void clickOnAddnew() {
			btnAddnew.click();
		}
		public void enterEmail(String email)
		{
			txtEmail.sendKeys(email);
		}
		public void enterPassword(String password)
		{
			txtPassword.sendKeys(password);
		}
		public void enterFirstName(String firstName)
		{
			txtFirstName.sendKeys(firstName);
		}
		public void enterLastName(String lastName)
		{
			txtLastName.sendKeys(lastName);
		}
		public void enterDob(String dob)
		{
			txtDob.sendKeys(dob);
		}
		public void enterCompanyName(String coName)
		{
			txtCompanyName.sendKeys(coName);
		}

		public void enterAdminContent(String content)
		{
			txtAdminContent.sendKeys(content);
		}
		public void enterManagerOfVendor(String value)
		{
			Select drp=new Select(dropdownVendorMgr);
			drp.selectByVisibleText(value);
		}
		public void enterNewsLetter()
		{
			txtNewsLetter.click();
//			ldriver.findElement(By.xpath("//option[contains(text(),'Your store name')]"));
//		Select drp=new Select(selectNewsLetter);			
//		//	drp.selectByVisibleText(value);
		Actions actions = new Actions(ldriver);
		actions.moveToElement(ldriver.findElement(By.xpath("//option[contains(text(),'Your store name')]"))).click().perform();
			
		}
		public void enterCustomerRoles(String value)
		{
			Select drp=new Select(txtCustomerRoles);
			drp.selectByVisibleText(value);
		}
		public void enterGender(String gender)
		{
			if(gender.equals("Male"))
			{
				MaleGender.click();
			}
			else if(gender.equals("Female"))
			{
				FeMaleGender.click();
			}
			else//default set Male gender
			{
				MaleGender.click();
			}

		}

		public void clickOnSave()
		{
			btnSave.click();
		}
}
