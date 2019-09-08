package FlightFollowing;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class UnitDisplayOption  extends BaseClass {
	// WebDriver driver;

	/*  @Test
	public void AircraftClick()  throws InterruptedException {

		Polling plg = new Polling();
		plg.verifyHomepageTitle();
	//	plg.VerifyLoginPage();
		plg.VerifyFrame();
	}
	 */
	@Test(priority=3)
	public void VerifyAircraftClick() throws InterruptedException {
		logger = extent.createTest("Aircraft click Testt", "This  will test the Aircaft click");
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action =new Actions(driver);
		WebElement aircraft = driver.findElement(By.xpath("//*[@id=\"RadMenubar_m4\"]"));
		action.moveToElement(aircraft).moveToElement(driver.findElement(By.xpath("//*[@id=\"RadMenubar_m4_m2\"]"))).click().build().perform();
        logger.log(Status.PASS, "click on SubMenu");
		//new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.id("checkoutLink")));
		//  driver.findElement(By.id("checkoutLink")).click();

		driver.switchTo().frame("AircraftPreferencesWindow");
        logger.log(Status.INFO,"Switch to Aircraft frame");
		driver.findElement(By.xpath("//*[@id=\"RadTabStrip1_ctl03\"]")).click();
		logger.log(Status.PASS, "CLICK on Radio Button");
		Thread.sleep(5000);

		List<WebElement> list = driver.findElements(By.xpath("div[@id='Click-Section-Container']//input[@type='checkbox']"));
		for( int i=0;i<=list.size()-1; i++){

			//div[@id='Click-Section-Container']//input[@type='checkbox']
			WebElement elmnt = list.get(i);
			boolean loc   = elmnt.isSelected();
			if (loc == false) {

				list.get(i).click();
				logger.log(Status.PASS,"click on check box");
			}

			driver.findElement(By.xpath("//*[@id=\"Button5\"]")).click();
			logger.log(Status.PASS, "CLICK on Apply Radio Button");
			driver.findElement(By.xpath("//*[@id=\"Button1\"]")).click();
			logger.log(Status.PASS, "CLICK on  OK Radio Button");
			driver.switchTo().defaultContent();
			assertEquals(driver.getTitle(), "SkyWeb v5.04.05");
			logger.log(Status.PASS, "Home Page Loaded");
			
		}

	}



	}




 







