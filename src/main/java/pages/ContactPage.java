package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverFactory;
import cucumber.api.DataTable;



public class ContactPage extends DriverFactory{

	DriverFactory driverFactory;
	
	
	public ContactPage(DriverFactory driverFactory){
		this.driverFactory = driverFactory;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_NameBox']")
	public WebElement nameField;
	
	@FindBy(xpath = "//input[@id='ctl00_MainContent_EmailBox']")
	public WebElement emailField;
	
	@FindBy(xpath = "//*[@id='ctl00_MainContent_MessageBox']")
	public WebElement messageField;
	
	@FindBy(xpath = "//*[@id='ctl00_MainContent_SendButton']")
	public WebElement submit;
	
	@FindBy(xpath = "//*[@id='ctl00_MainContent_rfvEmailAddress']")
	public WebElement yourNameIsRequired;
	
	@FindBy(xpath = "//*[@id='ctl00_MainContent_rfvEmailAddress']")
	public WebElement anEmailAddressIsRequired;
	
	@FindBy(xpath = "//*[@id='ctl00_MainContent_rfvMessage']")
	public WebElement pleaseTypeYourMessage;
	
	public List<List<String>> inputCustomerDetails(DataTable _table){
		List <List<String>> data = _table.raw();
		nameField.sendKeys(data.get(0).get(1));
		emailField.sendKeys(data.get(1).get(1));
		messageField.sendKeys(data.get(2).get(1));
		return data;
	}
	
	public boolean validateNameInput(){
		//driverFactory.getDriver().findElement(By.xpath("//*[@id='ctl00_MainContent_rfvEmailAddress']")).isDisplayed();
		yourNameIsRequired.isDisplayed();
		return false;
	}
	
	public boolean validateEmailInput(){
		anEmailAddressIsRequired.isDisplayed();
		return false;
	}
	
	public boolean validateMessageText(){
		pleaseTypeYourMessage.isDisplayed();
		return false;
	}
}
