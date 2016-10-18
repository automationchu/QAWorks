package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.DriverFactory;

public class QAWorksLandingPage extends DriverFactory{

	DriverFactory driverFactory;
	public static String homePage = "http://qaworks.com";
	
	@FindBy(linkText = "Contact")
	public WebElement contactLink;
	
	public QAWorksLandingPage(DriverFactory driverFactory){
		this.driverFactory = driverFactory;
		PageFactory.initElements(driver, this);
	}
	
	public QAWorksLandingPage navigateToHomePage(){
		driverFactory.getDriver().navigate().to(homePage);
		return new QAWorksLandingPage(driverFactory);
	}
	
	public ContactPage goToContactPage(){
		contactLink.click();
		return new ContactPage(driverFactory);
	}
}
