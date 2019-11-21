package stepDefinitions;
import cucumber.TestContext;
import pageObjects.CartSummaryPage;
import pageObjects.EnvironmentVariables;
import pageObjects.MyAccountPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CartSummaryPageSteps {
	TestContext testContext;
	CartSummaryPage cartSummaryPage;
	MyAccountPage myaccountPage;
	EnvironmentVariables environmentVariables;
	public CartSummaryPageSteps(TestContext context) {
		 testContext = context;
		 cartSummaryPage = testContext.getPageObjectManager().getCartSummaryPage();
		 environmentVariables = testContext.getPageObjectManager().getEnvVariables();
	}
	
	@When("^user navigate to Cart Summary page$")
	public void user_navigate_to_Cart_Summary_page() {
		if(cartSummaryPage.verifyUserIsOnCartSummaryPg()) {
			System.out.println("User navigated to Cart summary page.");
		}
		else {
			myaccountPage.logoutfromTheApplication();
			throw new Error("Navigation to the Cart summary failed.");
		}
	}
	
	@Then("^user confirms that same item is added to the cart$")
	public void user_confirms_that_same_item_is_added_to_the_cart() {
		String result = cartSummaryPage.verifySameItemIsAddedToTheCart(environmentVariables.itemName);
		 String arrx[]=result.split("-");
		 if(arrx[0].equals("Pass")) {
			 System.out.println(arrx[1]); 
		 }
		 else {
			 testContext.getWebDriverManager().closeDriver();
			 throw new Error(arrx[1]);
		 }	
	}
}
