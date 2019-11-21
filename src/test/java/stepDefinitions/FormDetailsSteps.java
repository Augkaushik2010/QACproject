package stepDefinitions;
import cucumber.TestContext;
import pageObjects.FormDetails;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pageObjects.EnvironmentVariables;

public class FormDetailsSteps {
	TestContext testContext;
	FormDetails formDetails;
	EnvironmentVariables environmentVariables;
	
	public FormDetailsSteps(TestContext context) {
		 testContext = context;
		 formDetails = testContext.getPageObjectManager().getFormDetails();
		 environmentVariables = testContext.getPageObjectManager().getEnvVariables();
		 }
	
	@Then ("^verify user is on Registration screen$")
	public void verify_user_is_on_Registration_screen() {
		String result = formDetails.verifyUserIsOnRegistrationDetailsPage();
		 String arrx[]=result.split("-");
		 if(arrx[0].equals("Pass")) {
			 System.out.println(arrx[1]); 
		 }
		 else {
			 throw new Error(arrx[1]);
		 }
	}
	
	@Then("^Verify the Mandatory fields$")
	public void Verify_the_Mandatory_fields() {
		String result = formDetails.verifyMandatoryFieldsOfRegPg();
		String arrx[]=result.split("-");
		 if(arrx[0].equals("Pass")) {
			 System.out.println(arrx[1]); 
		 }
		 else {
			 throw new Error(arrx[1]);
		 }
	}
	
	@When("^user selects title \"([^\"]*)\"$")
	public void user_selects_title(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		formDetails.selectRBtnasPerInput(arg1);
	}
@When("^user types first name \"([^\"]*)\"$")
public void user_types_first_name(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	formDetails.enterFirstName(arg1);
	environmentVariables.firstName=arg1;
}

@When("^user types sur name \"([^\"]*)\"$")
public void user_types_sur_name(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	formDetails.enterSurName(arg1);
	environmentVariables.lastName=arg1;
}

@When("^user enters password \"([^\"]*)\"$")
public void user_enters_password(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    formDetails.enterPassword(arg1);
    environmentVariables.loginpassword=arg1;
}

@When("^user enters address \"([^\"]*)\"$")
public void user_enters_address(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    formDetails.enterAddressline1(arg1);
}

@When("^user enters city \"([^\"]*)\"$")
public void user_enters_city(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    formDetails.enterCity(arg1);
}

@When("^user selects the state \"([^\"]*)\"$")
public void user_selects_the_state(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    formDetails.selectState(arg1);
}

@When("^user enters the zip \"([^\"]*)\"$")
public void user_enters_the_zip(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    formDetails.enterPostalCode(arg1);
}

@When("^user selects the country \"([^\"]*)\"$")
public void user_selects_the_country(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   formDetails.selectCountry(arg1);
}

@When("^user enters mobile phone \"([^\"]*)\"$")
public void user_enters_mobile_phone(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   formDetails.enterMobileNum(arg1);
}

@When("^user enters address alias \"([^\"]*)\"$")
public void user_enters_address_alias(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    formDetails.enterAliasName(arg1);
}

@When("^clicks on Register Button$")
public void clicks_on_Register_Button() throws Throwable{
	System.out.println("clicking on registration button");
	formDetails.clkOnRegistration();
}

}