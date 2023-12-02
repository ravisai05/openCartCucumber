package stepDefinition;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;
import com.pageObjects.MyAcctPage;
import com.pageObjects.RegisterPag;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import utlis.DataReader;


public class Steps {
	WebDriver driver;
	ResourceBundle rb;
	Logger logger;
	LoginPage lp;
	HomePage hp;
	RegisterPag rg;
	String brow;
	MyAcctPage mact;
	List<HashMap<String, String>> datamap;
	
	@Before
	public void setup() {
		logger = LogManager.getLogger(this.getClass());
		rb=ResourceBundle.getBundle("config");
		brow=rb.getString("browser");
		
		
	}
	@After
	public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
           TakesScreenshot ts=(TakesScreenshot) driver;
           //returns screenshot and store in byte varible
           byte[]  screenshot=ts.getScreenshotAs(OutputType.BYTES);
           //directly attach to report
           scenario.attach(screenshot, "img/png", scenario.getName());
           
           
        }
       
        driver.quit();
    }
	@Given("User opens browser {string}")
	public void user_opens_browser(String brow){
		
	    switch (brow) {
	    case "chrome":
	    	driver=new ChromeDriver();
	    	break;
	    case "edge":
	    	driver=new EdgeDriver();
	    case "firefox":
	    	driver=new FirefoxDriver();
	    }
	    
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	}

	@Given("User provides URL {string}")
	public void user_provides_url(String url) {
	  
	 driver.get(rb.getString(url));
	 logger.info("url Launched");
	}

	@When("User navigates to my accountant menu")
	public void user_navigates_to_my_accountant_menu() {
		
		hp=new HomePage(driver);
		
		
		
	}
	@When("User clicks on my account")
	public void user_clicks_on_my_account() {
		hp.clickMyAcct();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		logger.info("User navigates to my accountant menu");
	}

	@When("User clicks on login")
	public void user_clicks_on_login() {
	    hp.clickLogin();
	    logger.info("User clicks on login");
	}

	@When("User provides email as {string} and Password as {string}")
	public void user_provides_email_as_and_password_as(String email, String password) {
	  lp =new LoginPage(driver);
	  lp.setEmail(email);
	  lp.setPassword(password);
	  logger.info("User provides email as {string} and Password as {string}");
	}
	
	@When("click on Login")
	public void click_on_login() {
	   lp.clickLogin();
	}



	
	
	
	@Then("User navigates to my account page\"valid\"")
	public void user_navigates_to_my_account_page_valid() {
		try {
			mact=new MyAcctPage(driver);
			 boolean res=mact.isMyAccountExist();
			 Assert.assertTrue(res);
		}catch (Exception e) {
			Assert.fail();
		}
	}
	

	@Then("User navigates to my account page\"invalid\"")
	public void user_navigates_to_my_account_page_invalid() {
		try {
			mact=new MyAcctPage(driver);
			 boolean res=mact.isMyAccountExist();
			 Assert.assertFalse(res);
		}catch (Exception e) {
			// TODO: handle exception
			Assert.fail();
		}
	}
	@Then("User navigates to my account page by providing user details {string}")
	public void user_navigates_to_my_account_page_by_providing_user_details(String string) {
		datamap = DataReader.data("C:\\Users\\SAI\\eclipse-workspace\\openCartCucumber\\src\\test\\resources\\opentextLoginDetails.xlsx", "Sheet1");
		int index=Integer.parseInt(string)-1;
		String email=datamap.get(index).get("Email");
		String password=datamap.get(index).get("Password");
		String res=datamap.get(index).get("Expected Result");
		
		lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();
		if (res.equals("valid")) {
			try {
				mact=new MyAcctPage(driver);
				logger.info("user logged in myacct page ");
				 boolean result=mact.isMyAccountExist();
				 Assert.assertTrue(result);
				 logger.info("valid assertion ");
			}catch (Exception e) {
				Assert.fail();
			}
		}
		else {
			try {
				mact=new MyAcctPage(driver);
				logger.info("user logged in myacct page ");
				 boolean result=mact.isMyAccountExist();
				 Assert.assertFalse(result);
				 logger.info("in valid assertion ");
			}catch (Exception e) {
				// TODO: handle exception
				Assert.fail();
			}
		}
	}


}
