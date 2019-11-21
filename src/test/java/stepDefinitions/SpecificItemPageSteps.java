package stepDefinitions;
import cucumber.TestContext;
import pageObjects.SpecificItemPage;
import pageObjects.EnvironmentVariables;
import pageObjects.MyAccountPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class SpecificItemPageSteps {
	TestContext testContext;
	SpecificItemPage specificitemPage;
	MyAccountPage myaccountPage;
	EnvironmentVariables environmentVariables;
	public SpecificItemPageSteps(TestContext context) {
		 testContext = context;
		 specificitemPage = testContext.getPageObjectManager().getSpecificItemPage();
		 environmentVariables = testContext.getPageObjectManager().getEnvVariables();
	}
	@Then("^user can see Add To Wishlist option under Add To Cart button$")
	public void user_can_see_Add_To_Wishlist_option_under_Add_To_Cart_button() {
		if(specificitemPage.verifyWishlistbuttonDisplayedUnderAddToCartBtn()) {
			//do nothing
		}
		else {
			myaccountPage.logoutfromTheApplication();
			testContext.getWebDriverManager().closeDriver();
			throw new Error("Add To Wishlist didn't displayed under Add To Cart.");
		}
	}
	@When("^user add the item to cart$")
	public void user_add_the_item_to_cart() {
		environmentVariables.itemName = specificitemPage.retItemName();
		specificitemPage.clkOnAddToCartBtn();
		specificitemPage.clkOnProceedToCheckoutbtn();
		//specificitemPage.clkOnAddToWishlistButton();
	}
	@Then("^Application confirms that item is \"([^\"]*)\"$")
	public void Application_confirms_that_item_is(String arg1) {
		if(specificitemPage.verifyTheMsgAfterClkOnWishlistBtn(arg1)) {
			specificitemPage.closeTheDialogOpened();
		}
		else {
			specificitemPage.closeTheDialogOpened();
			myaccountPage.logoutfromTheApplication();
			testContext.getWebDriverManager().closeDriver();
			throw new Error("Item added to wishlist message not displayed as expected."+arg1);
		}
		
	}
	@When("^user navigate to My account page$")
	public void user_navigate_to_My_account_page() {
		specificitemPage.navigateToMyAccountPg();
	}
}
