package stepDefinitions;
import cucumber.TestContext;
import pageObjects.MyWishlistsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.MyAccountPage;
public class MyWishlistsPageSteps {
	TestContext testContext;
	MyWishlistsPage mywishlistsPage;
	MyAccountPage myacntpage;
	public MyWishlistsPageSteps(TestContext context) {
		 testContext = context;
		 mywishlistsPage = testContext.getPageObjectManager().getMyWishlistsPage();
	}
	
	@Then("^user can see \"([^\"]*)\" in My Store Page$")
	public void user_can_see_list_in_My_Store_Page(String arg1) {
		if(mywishlistsPage.verifyTopSellersListDisplayed(arg1)) {
			// do nothing
		}
		else {
			myacntpage.logoutfromTheApplication();
			testContext.getWebDriverManager().closeDriver();
			throw new Error("Top Sellers list is not displayed.");
		}
	}
	@When("^user click on first item in TOP SELLERS list$")
	public void user_click_on_first_item_in_TOP_SELLERS_list() {
		mywishlistsPage.clkOnFirstItemInTopSellers();
	}
}
