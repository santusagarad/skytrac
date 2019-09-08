package FlightFollowing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class CurrentPageChecks  extends BaseClass{

	@Test(priority=1)
	public  void VerifyLinks() throws InterruptedException {
		logger = extent.createTest("Page Links test", "This  will test the Current page link");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"SkyTrac_Controls_49\"]/table/tbody/tr/td[3]/table/tbody/tr/td[7]/img")).click();
		logger.log(Status.PASS, "Clicked on the Green Check mark");
		driver.switchTo().frame("ErrorWindow");
		//WebElement iframe = driver.findElement(By.xpath("//iframe[@name='ErrorWindow' and @class='InnerFrame']"));
	//	Assert.assertEquals(true,iframe.isDisplayed());
		logger.log(Status.PASS,"Frame Switched to error window");
		
		driver.findElement(By.xpath("//*[@id=\"ErrorMsg\"]")).getText();
		logger.log(Status.INFO, "If the erroe message was there it will get the message");
		driver.findElement(By.xpath("//input[@class='button' and @value='Done']")).click();
		logger.log(Status.PASS,"Clicked on the DONE Button");
		driver.switchTo().defaultContent();
		logger.log(Status.PASS,"Clicked on the DONE Button");
		driver.findElement(By.xpath("//*[@id=\"ProgramMenuImage\"]/img")).click();
		logger.log(Status.PASS,"Clicked on Home Button");
		//String actualTitle = driver.getTitle();
		//String expectedTitle = "Home";
		//Assert.assertEquals(actualTitle, expectedTitle);
		//BaseClass base= new BaseClass();
		VerifyLoadDataWindow();
		logger.log(Status.PASS,"Clicked on the DONE Button");
		driver.findElement(By.xpath("//*[@id=\"MailImageIcon\"]")).click(); 
		logger.log(Status.PASS,"Clicked on the MAIL Button");
		driver.switchTo().frame("MailWindow");
	//	WebElement iframe2 = driver.findElement(By.xpath("//iframe[@id=\"SkyTrac_Controls_Window_InnerFrame_398\"]"));
	//	Assert.assertEquals(true,iframe2.isDisplayed());
		logger.log(Status.PASS,"Frame Switched to MAIL Frame");
		driver.findElement(By.xpath("//*[@class='image-button close']")).click();
		logger.log(Status.PASS,"LogOut Button has clickced");

	}

	@Test(priority=2)
	public void NavigationPage() throws InterruptedException {
		logger = extent.createTest("Navigation Page Checkt", "This  will test the Navigation Page");
		WebElement logname = driver.findElement(By.id("//td[text()='rcas_mithun']"));
		Thread.sleep(2000);
		logname.getText();
		logger.log(Status.INFO,"Get the Username");
		String Expectedname = "rcas_mithun";
		Assert.assertEquals(logname, Expectedname);
		logger.log(Status.INFO,"Verified Username");
		String serverstatus = driver.findElement(By.id("//*[@id=\"SkyTrac_Controls_49\"]/table/tbody/tr/td[3]/table/tbody/tr/td[5]")).getText();
		logger.log(Status.INFO,"Get the ServerStatus");
		String Expectedstatus = "SKYWEB15 (LIVE)";
		Assert.assertEquals(serverstatus, Expectedstatus);
		logger.log(Status.PASS, "Verified ServerStatus");


	}

}
