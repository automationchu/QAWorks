package steps;

import org.junit.Assert;

import base.DriverFactory;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.ContactPage;
import pages.QAWorksLandingPage;

public class QaWorksStepDefintions {
	
	DriverFactory driverFactory;
	QAWorksLandingPage QAWlandingPage;
	ContactPage contactPage;
	
	public QaWorksStepDefintions(DriverFactory driverFactory)
	{
		this.driverFactory = driverFactory;
	}

	@Given("^I am on the QAWorks Site$")
	public void i_am_on_the_QAWorks_Site() throws Throwable {
		QAWlandingPage = new QAWorksLandingPage(driverFactory).navigateToHomePage() ;
		
	}
	
	@And("^I click on the Contact link$")
	public void i_click_on_the_Contact_link() throws Throwable {
		contactPage = QAWlandingPage.goToContactPage();
		contactPage = new ContactPage(driverFactory);
	}
 
	@And("^I input the following details$")
	public void i_input_the_following_details(DataTable table) throws Throwable {
	    contactPage.inputCustomerDetails(table);
	    contactPage.submit.click();
	}
	
	@Then("^QAWorks will be able to contact me$")
	public void qaworks_will_be_able_to_contact_me() throws Throwable {
		Assert.assertTrue(!contactPage.validateNameInput());
		Assert.assertTrue(!contactPage.validateEmailInput());
		Assert.assertTrue(!contactPage.validateMessageText());
		
	}
	
	

}
