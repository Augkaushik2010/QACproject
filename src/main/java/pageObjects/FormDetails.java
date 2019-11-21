package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class FormDetails {
	WebDriver driver;
	
	public FormDetails(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//User account creation details page - Radio button Mr
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Title')]//following::input[1]")
	private static WebElement rbGener1;
	//User account creation details page - Radio button Mrs
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Title')]//following::input[2]")
	private static WebElement rbGener2;
	//User account creation details page - First Name field
	@FindBy(how=How.XPATH,using = "//*[@id='customer_firstname']")
	private static WebElement txtFirstName;
	//User account creation details page - Last Name field
	@FindBy(how=How.XPATH,using = "//*[@id='customer_lastname']")
	private static WebElement txtLastName;
	//User account creation details page - Password field
	@FindBy(how = How.XPATH, using = "//*[@id='passwd']")
	private static WebElement txtPassword;
	//User account creation details page - Address line1 field
	@FindBy(how = How.XPATH, using = "//*[@id='address1']")
	private static WebElement txtAddress;
	//User account creation details page - City field
	@FindBy(how = How.XPATH, using = "//*[@id='city']")
	private static WebElement txtCity;
	//User account creation details page - State drop down list field
	@FindBy(how = How.XPATH, using = "//*[@id='id_state']")
	private static WebElement listState;
	//User account creation details page - Zip/Postal code field
	@FindBy(how = How.XPATH, using = "//*[@id='postcode']")
	private static WebElement txtPostCode;
	//User account creation details page - Country drop down list field
	@FindBy(how = How.XPATH, using = "//*[@id='id_country']")
	private static WebElement listCountry;
	//User account creation details page - Mobile number field
	@FindBy(how = How.XPATH, using = "//*[@id='phone_mobile']")
	private static WebElement txtMobileNumber;
	//User account creation details page - Alias name field
	@FindBy(how = How.XPATH, using = "//*[@id='alias']")
	private static WebElement txtAlias;
	//User account creation details page - Register button to create the account
	@FindBy(how = How.XPATH, using = "//span[text()='Register']")
	private static WebElement btnRegister;
	//User creation page - create account element
	@FindBy(how=How.XPATH,using="//*[text()='Create an account']")
	private static WebElement creatAccntPg;
	//User registration page - Warning message
	@FindBy(how=How.XPATH,using="//*[@class='alert alert-danger']")
	private static WebElement WarnMsgMandatFields;
	
	
	//The below method checks the input and select Mr/Mrs based on that.
	public void selectRBtnasPerInput(String arg1) {
		String title1 = "mr";
		String title2 = "mrs";
		if(title1.equalsIgnoreCase(arg1)) {
			rbGener1.click();
		}
		else if(title2.equalsIgnoreCase(arg1)) {
			rbGener2.click();
		}
		else {
			System.out.println("not a valid input"+arg1);	
		}
			
	}
	
	//The below method enter First name
	public void enterFirstName(String arg1) {
		txtFirstName.sendKeys(arg1);
	}
	
	//The below method enter Last name
	public void enterSurName(String arg1) {
		txtLastName.sendKeys(arg1);
	}
	
	//The below method enter Password
	public void enterPassword(String arg1) {
		txtPassword.sendKeys(arg1);
	}
	
	//The below method enter Address line1 mandatory field
	public void enterAddressline1(String arg1) {
		txtAddress.sendKeys(arg1);
	}
	
	//The below method enter City name
	public void enterCity(String arg1) {
		txtCity.sendKeys(arg1);
	}
	
	//The below method selects the state from dropdown list
	public void selectState(String arg1) {
		listState.click();
		 Select dropdownState = new Select(listState);
		 dropdownState.selectByVisibleText(arg1);
	}
	
	//The below method enter zip/postal code
	public void enterPostalCode(String arg1) {
		txtPostCode.sendKeys(arg1);
	}
	
	//The below method selects the country from dropdown list
	public void selectCountry(String arg1) {
		listCountry.click();
		 Select dropdownCountry = new Select(listCountry);
		 dropdownCountry.selectByVisibleText(arg1);
	}
	
	//The below method enter Mobile number
	public void enterMobileNum(String arg1) {
		txtMobileNumber.sendKeys(arg1);
	}
	
	//The below method enter Alias name
	public void enterAliasName(String arg1) {
		txtAlias.clear();
		txtAlias.sendKeys(arg1);
	}
	
	//The below method clicks on Registration button to complete the new user registration
	public void clkOnRegistration() throws InterruptedException {
		
		Thread.sleep(8000);

		 if(btnRegister.isDisplayed()) {
			 btnRegister.click();
		 }
		//btnRegister.click();
	}
	
	//The below mehtod validates user is on Registration details page
	public String verifyUserIsOnRegistrationDetailsPage() {
		if(creatAccntPg.isDisplayed()) {
			return "Pass-User navigated to the registration page.";
		}
		else {
			return "Fail-User navigated to the registration page.";
		}
	}
	
	//The below method validates the mandatory fiedls of registration page
	public String verifyMandatoryFieldsOfRegPg() {
		String warnings = null;
		int Totalwrngs=0;
		String outputmsg=null;
		if(WarnMsgMandatFields.isDisplayed()) {
			if(WarnMsgMandatFields.getText().contains("You must register at least one phone number")) {
				warnings = "1.Phone number";
				Totalwrngs=Totalwrngs+1;
			}
			if(WarnMsgMandatFields.getText().contains("lastname is required")) {
				warnings = warnings+"2.Last Name";
				Totalwrngs=Totalwrngs+1;
			}
			if(WarnMsgMandatFields.getText().contains("firstname is required")) {
				warnings = warnings+"3.First Name";
				Totalwrngs=Totalwrngs+1;
			}
			if(WarnMsgMandatFields.getText().contains("passwd is required")) {
				warnings = warnings+"4.Password";
				Totalwrngs=Totalwrngs+1;
			}
			if(WarnMsgMandatFields.getText().contains("address1 is required")) {
				warnings = warnings+"5.Address1";
				Totalwrngs=Totalwrngs+1;
			}
			if(WarnMsgMandatFields.getText().contains("city is required")) {
				warnings = warnings+"6.City";
				Totalwrngs=Totalwrngs+1;
			}
			if(WarnMsgMandatFields.getText().contains("The Zip/Postal code you've entered is invalid")) {
				warnings = warnings+"7.Zip";
				Totalwrngs=Totalwrngs+1;
			}
			if(WarnMsgMandatFields.getText().contains("This country requires you to choose a State")) {
				warnings = warnings+"8.State";
				Totalwrngs=Totalwrngs+1;
			}
			if(Totalwrngs==8) {
				 outputmsg=  "Pass-All the warning messages displayaed as: "+warnings;
			}
			else {
				 outputmsg=   "Fail-The warning messages displayaed are: "+warnings;
			}
			return outputmsg;
		}
		else {
			return "Fail";
		}
	}
}
