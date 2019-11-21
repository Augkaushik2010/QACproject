package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import managers.FileReaderManager;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Below method will launch the applicaton URL
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		//driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
	//Sign in link - Home Page object
	@FindBy(how=How.XPATH,using = "//*[contains(text(),'Sign in')]")
	private static WebElement lnkSignIn;
	
	//Below method clicks on the Sign in link from the Home page
	public void clkOnSignInlink() {
		lnkSignIn.click();
	}
	
}
