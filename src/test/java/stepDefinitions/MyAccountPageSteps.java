package stepDefinitions;
import cucumber.TestContext;
import pageObjects.EnvironmentVariables;
import pageObjects.MyAccountPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class MyAccountPageSteps {
	TestContext testContext;
	MyAccountPage myaccountPage;
	EnvironmentVariables environmentVariables;
	public MyAccountPageSteps(TestContext context) {
		 testContext = context;
		 myaccountPage = testContext.getPageObjectManager().getMyAccountPage();
		 environmentVariables = testContext.getPageObjectManager().getEnvVariables();
	}
	
	@Then("^user logged in and navigates to my account page$")
	public void user_logged_in_and_navigates_to_my_account_page() {
			if(myaccountPage.comparePageTitle()) {
				//do nothing
			}
			else {
				myaccountPage.logoutfromTheApplication();
				testContext.getWebDriverManager().closeDriver();
				throw new Error("Navigation to My Account page unsucessful.");
			}
	}
	
	@Then("^user name displayed in top right corner$")
	public void user_name_displayed_in_top_right_corner() {
		String fstName = environmentVariables.firstName;
		String lastName = environmentVariables.lastName;
		if(myaccountPage.verifyloggedInUserName(fstName, lastName)) {
			//do nothing
			System.out.println("User name is displayed as expected: "+fstName+" "+lastName);
		}
		else {
			myaccountPage.logoutfromTheApplication();
			testContext.getWebDriverManager().closeDriver();
			throw new Error("User name not displayed as expected."+fstName+" "+lastName);
		}
	}
	
	
	
	@Then("^user can see \"([^\"]*)\" in My Account Page$")
	public void user_can_see_in_My_Account_Page(String arg1) {
		if(myaccountPage.verifyMywishlistlnkDisplayed(arg1)) {
			// do nothing
		}
		else {
			myaccountPage.logoutfromTheApplication();
			testContext.getWebDriverManager().closeDriver();
			throw new Error(" My Wishlists link is not displayed in My Account page.");
		}
	}
	@When("^user click on my wishlists link$")
	public void user_click_on_my_wishlists_link() {
		myaccountPage.clkMyWishlistslink();
	}
	@Then("^user confirms that item is added to the wishlist$")
	public void user_confirms_that_item_is_added_to_the_wishlist() {
		if(myaccountPage.VerifyTheQuantityequalsToOne()) {
			//do nothing
		}
		else {
			myaccountPage.logoutfromTheApplication();
			testContext.getWebDriverManager().closeDriver();
			throw new Error("validation failed");
		}
	}
	@Then("^logout the application$")
	public void logout_from_the_application() {
		myaccountPage.logoutfromTheApplication();
		testContext.getWebDriverManager().closeDriver();
	}
}
