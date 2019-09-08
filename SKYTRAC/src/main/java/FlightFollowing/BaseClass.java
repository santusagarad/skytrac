  
package FlightFollowing;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Cinfig.PropertiesFile;

public class BaseClass {


	public static 	WebDriver driver;
	ExtentReports extent;
	ExtentTest logger;
	ExtentHtmlReporter htmlReporter;
	static String username = "RCAS_PM";
	static String password = "Skytrac3#";
	String baseUrl = "https://skyweb15.skytrac.ca";
	String driverPath = System.getProperty("user.dir");
	public static String BrowserName=null;
	// @DataProvider(name = "Authentication")
	//  String htmlReportPath = "C:\\Screenshots/MyOwnReport.html"; //Path for the HTML report to be saved

	@BeforeClass
	public void setup(){
		htmlReporter = new ExtentHtmlReporter("FlightFollowingTestCases.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}
	@BeforeTest(alwaysRun=true)
	public void Browser()  {
		
		PropertiesFile.GetProperties();  

		if(BrowserName.equalsIgnoreCase("Chrome")){
			String driverPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", driverPath+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			String driverPath = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", driverPath+"\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			
			System.out.println(BrowserName + " --> no browser is defined");
		}
	}
//
//	 public static Object[][] credentials() {
//		 
//	        // The number of times data is repeated, test will be executed the same no. of times
//	 
//	        // Here it will execute two times
//	 
//	        return new Object[][] { { "username", "rcas_mithun" }, { "username", "rcas_mithun" }};
//	 dataProvider = "Authentication"
//	  }

	@Test(priority=1)
	public void verifyHomepageTitle() throws InterruptedException {
		logger = extent.createTest("VerifyHomepage");

		//prop.load(input);
		driver.get(baseUrl);
		logger.log(Status.PASS, "Navigate to URL");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		assertEquals(driver.getTitle(), "Login");
		logger.log(Status.PASS, " LogIn Page Loaded");

		driver.findElement(By.xpath("//input[@id='ctl00_MainContentPlaceHolder_skyWebLogin_UserName']")).sendKeys(username);
		logger.log(Status.PASS, "Username Entered");
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContentPlaceHolder_skyWebLogin_Password\"]")).sendKeys(password);
		logger.log(Status.PASS, "Password Entered");
		driver.findElement(By.id("ctl00_MainContentPlaceHolder_skyWebLogin_LoginButton")).click();
		logger.log(Status.PASS, "LogIn Successful");


	}

	@Test(priority=2)
	public void VerifyLoadDataWindow() throws InterruptedException {
		logger = extent.createTest("VerifyLoadDataWindow");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement Link =	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\"FLIGHT FOLLOWING\")]")));
		Link.click();
		logger.log(Status.INFO, "Clicked on FlightFollowing");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.switchTo().frame("SkyTrac_Controls_Window_InnerFrame_52");
		logger.log(Status.PASS, "Switching Frame");
		driver.findElement(By.xpath("//input[@id='Ok']")).click();
		logger.log(Status.PASS, "Click Ok");
		logger.pass("FindElements");
		
		assertEquals(driver.getTitle(), "SkyWeb v5.05.00");
		logger.log(Status.PASS, "Home Page Loaded");
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		//log
	}

	@AfterMethod(alwaysRun=true)
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test case FAILED due to below issues:", ExtentColor.RED));
			logger.fail(result.getThrowable());

		}
		else if (result.getStatus() == ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
		else if (result.getStatus() == ITestResult.SKIP)
		{
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " Test Case SKIPPED", ExtentColor.BLUE));
		}
	}
	@AfterClass()
	public void VerifyLogOut() throws InterruptedException {
		logger = extent.createTest("VerifyLogOut" );
		driver.switchTo().defaultContent();
		logger.log(Status.PASS,"switch to default");
		driver.findElement(By.xpath("//*[@id=\"LogoutImage\"]/img")).click(); 
		logger.log(Status.PASS,"click on LogOut Button");
		Thread.sleep(5000);
		assertEquals(driver.getTitle(),"Login");
		extent.flush();
		driver.quit();
		// Thread.sleep(5000);
	}

}
