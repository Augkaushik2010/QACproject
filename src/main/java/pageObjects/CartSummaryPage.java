package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartSummaryPage {
	WebDriver driver;
	
	public CartSummaryPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Cart summary page - item name
	@FindBy(how = How.XPATH,using="//*[@class='cart_description']")
	private WebElement itemNameInCartSummaryPg;
	
	public boolean verifyUserIsOnCartSummaryPg() {
		if(driver.getTitle().contains("Order - My Store")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String verifySameItemIsAddedToTheCart(String ItemNameToCompare) {
		System.out.println(itemNameInCartSummaryPg.getText());
		
		if(itemNameInCartSummaryPg.getText().contains(ItemNameToCompare)) {
			return "Pass-Same item is added to the cart"+itemNameInCartSummaryPg.getText();
		}
		else {
			return "Fail-Same item is not added to the cart."+itemNameInCartSummaryPg.getText();
		}

	}
}
