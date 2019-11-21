package managers;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.SignInPage;
import pageObjects.EnvironmentVariables;
import pageObjects.FormDetails;
import pageObjects.MyWishlistsPage;
import pageObjects.SpecificItemPage;
import pageObjects.CartSummaryPage;

public class PageObjectManager {
	 
	private WebDriver driver;
	 
	private HomePage homePage;
	private SignInPage signinPage;
	private FormDetails formDetails;
	private MyAccountPage myaccountPage;
	private MyWishlistsPage mywishlistsPage;
	private SpecificItemPage specificitemPage;
	private EnvironmentVariables environmentVariables;
	private CartSummaryPage cartSummaryPage;
	 
	 public PageObjectManager(WebDriver driver) {
		 this.driver = driver;
	 }
	public HomePage getHomePage(){
		 return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	public SignInPage getSignInPage() {
		return (signinPage == null) ? signinPage = new SignInPage(driver) : signinPage;
	}
	public FormDetails getFormDetails() {
		return (formDetails == null) ? formDetails = new FormDetails(driver) : formDetails;
	}
	public MyAccountPage getMyAccountPage() {
		return (myaccountPage == null) ? myaccountPage = new MyAccountPage(driver) : myaccountPage;
	}
	public MyWishlistsPage getMyWishlistsPage(){	 
		 return (mywishlistsPage == null) ? mywishlistsPage = new MyWishlistsPage(driver) : mywishlistsPage;
    }	 
	public SpecificItemPage getSpecificItemPage() {	 
		 return (specificitemPage == null) ? specificitemPage = new SpecificItemPage(driver) : specificitemPage;
	}
	public EnvironmentVariables getEnvVariables() {	 
		 return (environmentVariables == null) ? environmentVariables = new EnvironmentVariables(driver) : environmentVariables;
	}
	public CartSummaryPage getCartSummaryPage() {	 
		 return (cartSummaryPage == null) ? cartSummaryPage = new CartSummaryPage(driver) : cartSummaryPage;
	}

}