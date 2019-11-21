package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountPage {
	WebDriver driver;
	public MyAccountPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//My Account page object - Capture the logged in user name
	@FindBy(how = How.XPATH, using = "//*[@class='header_user_info'][1]")
	private static WebElement loggedInUserName;
	//My Account page object - My Wishlists link
	@FindBy(how = How.XPATH, using = "//span[text()='My wishlists']")
	private static WebElement lnkmyWishlists;
	//My Account page object - Quantity field in wishlists table
	@FindBy(how = How.XPATH, using = "//table[@class='table table-bordered']/tbody/tr[1]/td[2]")
	private static WebElement qntyInWishlistsTable;
	//My Account page object - Sign out button
	@FindBy(how = How.XPATH, using = "//*[@title='Log me out']")
	private static WebElement signoutbtn;
	
	//The below method compares the page title and returns true/false
	public boolean comparePageTitle() {
		String pgTitleDisplayed = driver.getTitle();
		if(pgTitleDisplayed.contains("My account - My Store")) {
			System.out.println("user logged in successfully and the title of the page is: "+pgTitleDisplayed);
			return true;
		}
		else {
			System.out.println("user not logged in successfully and the title of the page is: "+pgTitleDisplayed);
			return false;
		}
	}
	
	//The below method Verify the registered user logged in or not and returns true/false
	public boolean verifyloggedInUserName(String arg1, String arg2) {
		String dispUserName = loggedInUserName.getText();
		String inputUserName = arg1+" "+arg2;
		System.out.println(inputUserName);
		System.out.println(dispUserName);
		if(dispUserName.contains(inputUserName)) {
			//System.out.println("user name displayed after logged in: "+dispUserName);
			return true;
		}
		else {
			//System.out.println("user name not displayed as expected after logged in: "+dispUserName);
			return false;
		}
	}
	
	//The below method checks My Wishlists link displayed in the page and returns true/false
	public boolean verifyMywishlistlnkDisplayed(String arg1) {
		String linkTextDisplayed = lnkmyWishlists.getText();
		if(linkTextDisplayed.equalsIgnoreCase(arg1)) {
			System.out.println("my wishlists link displayed.");
			return true;
		}
		else {
			System.out.println("my wishlists didn't displayed.");
			return false;
		}
	}
	
	//The below method clicks on My Wishlists link
	public void clkMyWishlistslink() {
		lnkmyWishlists.click();
	}
	
	//The below method Verifies my wishlists quantity is 1 for the newly registered user and returns true/false
	public boolean VerifyTheQuantityequalsToOne() {
		String quantitydisplayed = qntyInWishlistsTable.getText();
		int quntydisp = Integer.parseInt(quantitydisplayed);
		if(quntydisp == 1) {
			System.out.println("Item added successfully to the wishlist");
			return true;
		}
		else {
			System.out.println("Item is not added successfully to the wishlist");
			//driver.close();
			//throw new Error("validation failed");
			return false;
		}
	}
	
	//The below method clicks on sign out button
	public void logoutfromTheApplication() {
		signoutbtn.click();
	}
	
}
