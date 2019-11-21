package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.TestContext;
import pageObjects.HomePage;

//this class will take user to the sign on page.
public class HomePageSteps {
	 TestContext testContext;
	 HomePage homePage;
	 public HomePageSteps(TestContext context) {
		 testContext = context;
		 homePage = testContext.getPageObjectManager().getHomePage();
	}
	@Given("^user is on Signin page$")
	public void user_is_on_Signin_page() {
		homePage.navigateTo_HomePage();
		homePage.clkOnSignInlink();
	}
	
}
