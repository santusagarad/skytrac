package FlightFollowing;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


public class Polling extends BaseClass {



	@Test(priority=1)
	public void ToolsMenu() throws InterruptedException{
		logger = extent.createTest("Tools Menu Test", "This will test the Tools Menu");
		//driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		WebElement tools = driver.findElement(By.xpath("/html/body/form/div[4]/div[6]/ul/li[4]/a/span"));
		logger.log(Status.PASS, "Moved to Sublink Button and clicked"); 
		action.moveToElement(tools).moveToElement(driver.findElement(By.xpath("/html/body/form/div[4]/div[6]/ul/li[4]/div/ul/li[11]/a/span"))).click().build().perform();
		logger.log(Status.PASS, "Clicked on Button");
		Thread.sleep(5000);
		//	GetScreenShot.ScreenShot();

		File srcshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(srcshot, new File("C:\\Users\\User\\eclipse-workspace\\RCAS\\ScreenShots/Polling.png"));
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());

		} 


		WebElement Text = driver.findElement(By.xpath("//div[@id='SkyTrac_Controls_49']//parent::td[@class='Polling']"));
		System.out.println("Printing " + Text.getText());
		logger.log(Status.PASS, "Successfully printed polling ");


	}

	@Test(priority=2)
	public void PreferenceMenu() throws InterruptedException{
		logger = extent.createTest("Preference Menu Test", "This  will test the Preference Menu");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.switchTo().defaultContent();
		Actions action = new Actions(driver);
		logger.log(Status.PASS, "Clicked on Button");
		WebElement preferences = driver.findElement(By.xpath("//*[@id='RadMenubar_m4' ][@class='link ']"));
		action.moveToElement(preferences).moveToElement(driver.findElement(By.xpath("//*[@id=\"RadMenubar_m4_m12\"]/span"))).build().perform();
		logger.log(Status.PASS, "Moved on Sublink Button");
		Thread.sleep(500);

		WebElement submenu1=  driver.findElement(By.linkText("5 seconds"));
		logger.log(Status.PASS, "Moved on SubMenu link Button");
		action.moveToElement(submenu1).click().build().perform();
		Thread.sleep(2000);
		File srcshot1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {

			FileUtils.copyFile(srcshot1, new File("C:\\Users\\User\\eclipse-workspace\\RCAS\\ScreenShots/Polling5.png"));
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());

		}
		WebElement Text = driver.findElement(By.xpath("//*[@id=\"SkyTrac_Controls_49\"]/table/tbody/tr/td[3]/table/tbody/tr/td[3]"));
		System.out.println("Printing " + Text.getText());
		logger.log(Status.PASS, "Polling got printed");

		//driver.switchTo().defaultContent();



	}


}
