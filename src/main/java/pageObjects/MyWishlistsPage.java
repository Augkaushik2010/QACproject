package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class MyWishlistsPage {
	WebDriver driver;
	
	
	public MyWishlistsPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//My wishlists page - Top sellers link object
	@FindBy(how = How.XPATH, using = "//*[text()='Top sellers']")
	private static WebElement listTopSellers;
	
	//My wishlists page - first item from Top sellers object
	@FindBy(how = How.XPATH, using = "//*[@id='best-sellers_block_right']//li[1]//a[@class='product-name']")
	private static WebElement frstItemInTopSellers;
	
	//The below method verifies top sellers list displayed in the page and returns true/false
	public boolean verifyTopSellersListDisplayed(String arg1) {
		String dispText = listTopSellers.getText();
		if(dispText.equalsIgnoreCase(arg1)) {
			System.out.println("Top sellers list displayed in My Wishlists page.");
			return true;
		}
		else {
			System.out.println("Top sellers list is not displayed in My Wishlists page.");
			return false;
		}
	}
	
	//The below method clicks on the first item displayed under top sellers list
	public void clkOnFirstItemInTopSellers() {
		frstItemInTopSellers.click();
	}
	
	
}
