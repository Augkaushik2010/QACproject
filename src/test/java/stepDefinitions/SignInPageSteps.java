package stepDefinitions;

import cucumber.TestContext;
import pageObjects.SignInPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.FormDetails;
import pageObjects.EnvironmentVariables;


public class SignInPageSteps{
	TestContext testContext;
	SignInPage signinPage;
	FormDetails formDetails;
	EnvironmentVariables environmentVariables;
	
	public SignInPageSteps(TestContext context) {
		 testContext = context;
		 signinPage = testContext.getPageObjectManager().getSignInPage();
		 formDetails= testContext.getPageObjectManager().getFormDetails();
		 environmentVariables = testContext.getPageObjectManager().getEnvVariables();
		 }
	
	@When("^user enters \"([^\"]*)\" and click on create an account button$")
	public void user_enter_and_click_on_create_an_account_button(String arg1) {
		String logEmail = signinPage.enterEmailAddress(arg1);
		environmentVariables.loginEmail = logEmail;
		signinPage.clkOnCreateAccountBtn();
	    
	}
	
	
	@When("^click on create an account button$")
	public void click_on_create_an_account_button() {
		signinPage.clkOnCreateAccountBtn();
	}
	
	@When("^close the browser and quit$")
	public void close_the_browser_and_quit() {
		signinPage.closeThePgAndQuit();
	}
	
	@Given("^user enter email address to login$")
	public void user_enter_email_address_to_login() {
		signinPage.entEmailAddress(environmentVariables.loginEmail);
	}
	
	@Given("^user enter password to login$")
	public void user_enter_password_to_login() {
		signinPage.entPasswordToLogin(environmentVariables.loginpassword);
	}
	
	@When("^click on signin button to login$")
	public void click_on_signin_button_to_login() {
		signinPage.clkSignInBtnToLogin();
	}
	
	
	
}
