package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class SpecificItemPage {
	WebDriver driver;
	
	public SpecificItemPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//First item from top sellers list page - wish  list button.
	@FindBy(how = How.XPATH, using = "//span[text()='Add to cart']//following::a[@id='wishlist_button']")
	private static WebElement wishlstButton;
	//First item from top sellers list page - Added to your list text box object
	@FindBy(how = How.XPATH, using = "//*[text()='Added to your wishlist.']")
	private static WebElement addedToYourWishlist;
	//First item from top sellers list page - Close item on top of Added to your list text
	@FindBy(how = How.XPATH, using = "//*[text()='Added to your wishlist.']//following::a[1]")
	private static WebElement closeBtn;
	//First item from top sellers list page - below property is used to click on user name displayed on the right corner
	@FindBy(how = How.XPATH, using = "//*[@class='account']")
	private static WebElement myAccount;
	//First item from top sellers list page - get the dress name
	@FindBy(how = How.XPATH, using = "//*[@itemprop='name']")
	private static WebElement itemName;
	//First item from top sellers list page - Add to cart button
	@FindBy(how = How.XPATH, using = "//*[@name='Submit']")
	private static WebElement AddToCartBtn;
	//After adding item to cart - proceed to checkout button
	@FindBy(how = How.XPATH, using = "//*[@title='Proceed to checkout']")
	private static WebElement PrcdToChkoutBtn;
			
		
	//Below method verifies the wish list button displays under Add to cart button and returns true/false.
	public boolean verifyWishlistbuttonDisplayedUnderAddToCartBtn() {
		if(wishlstButton.isDisplayed()) {
			System.out.println("Add To Wishlist displayed under Add To Cart button.");
			return true;
		}
		else {
			System.out.println("Add To Wishlist is not displayed under Add To Cart button.");
			return false;
		}
	}
	
	//Below method clicks on Add to Wish list button.
	public void clkOnAddToWishlistButton() {
		wishlstButton.click();
	}
	
	//Below method verifies item added to your list message after click on Add to wishlist.
	public boolean verifyTheMsgAfterClkOnWishlistBtn(String arg1) {
		String dispText = addedToYourWishlist.getText();
		if(dispText.equalsIgnoreCase(arg1)) {
			System.out.println("Expected message displayed: "+dispText);
			return true;
		}
		else {
			System.out.println("Expected Text: "+arg1 +" but actual text displayed : "+dispText);
			return false;
		}
	}
	
	//Below method closes the pop up opened after adding item to wishlist.
	public void closeTheDialogOpened() {
		closeBtn.click();
	}
	
	//Below method clicks on user name on the right side corner of the application to navigate to my account page.
	public void navigateToMyAccountPg() {
		myAccount.click();
	}
	
	//Below method will return the dress/item name selected by the user from top sellers
	public String retItemName() {
		return itemName.getText();
	}
	//Below method will click on Add To Cart button
	public void clkOnAddToCartBtn() {
		AddToCartBtn.click();
	}
	//Below method will click on proceed to checkout button
	public void clkOnProceedToCheckoutbtn() {
		PrcdToChkoutBtn.click();
	}
}
