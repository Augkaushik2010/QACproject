package managers;
 
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
public class WebDriverManager {
 private WebDriver driver;
 private static DriverType driverType;
 private static EnvironmentType environmentType;
 private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
 private static String Node=FileReaderManager.getInstance().getConfigReader().getNodeUrl();
 DesiredCapabilities cap = DesiredCapabilities.chrome();
 //DesiredCapabilities cap = new DesiredCapabilities();
 
 public WebDriverManager() {
 driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
 environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment(); 
 }
 
 public WebDriver getDriver() throws MalformedURLException {
 if(driver == null) driver = createDriver();
 return driver;
 }
 
 private WebDriver createDriver() throws MalformedURLException {
    switch (environmentType) {     
         case LOCAL : driver = createLocalDriver();
          break;
         case REMOTE : driver = createRemoteDriver();
          break;
    }
    return driver;
 }
 
 
 
 private WebDriver createLocalDriver() {
      switch (driverType) {     
      case FIREFOX : driver = new FirefoxDriver();
      break;
      case CHROME : 
         System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
         driver = new ChromeDriver();
      break;
      case INTERNETEXPLORER : driver = new InternetExplorerDriver();
      break;
      }
 
      if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
 } 
 
 	public void closeDriver(){
 		driver.close();
 		driver.quit();
 	}
 
 	private WebDriver createRemoteDriver() throws MalformedURLException {
 		switch (driverType) {     
 	      case FIREFOX : driver = new FirefoxDriver();
 	      break;
 	      case CHROME : 
 	         System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
 	         //driver = new ChromeDriver();
 	    	 //System.setProperty("webdriver.chrome.driver","c:\\Grid\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				options.addArguments("test-type");
		        //driver = new ChromeDriver(options);
			     cap.setCapability(ChromeOptions.CAPABILITY, options);
			    // cap = DesiredCapabilities.chrome();
 	    	  System.out.println(Node);
 	    	  driver = new RemoteWebDriver(new URL(Node), cap);
 	      break;
 	      case INTERNETEXPLORER : driver = new InternetExplorerDriver();
 	      break;
 	      }
 	 
 	      if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
 	        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
 	        return driver;
 	}
}