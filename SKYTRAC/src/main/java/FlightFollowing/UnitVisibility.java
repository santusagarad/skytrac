
package FlightFollowing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class UnitVisibility   extends BaseClass {
   //   jdshfsdgkshksfduedcas.gfjhgasjgfskajjsafjsagfajsgal/dka;dpkfdkjfklhkahkfsfncsdfhaSaodwodadusfhudvcdvb nxc  cnmvncbbnmn.,mm/,.l';lplkpiohtuer
	@Test(priority=8)
	public void VerifyAircraft()throws InterruptedException {
		logger = extent.createTest("Aircraft  Testt", "This  will test the Aircaft ");
		Actions action = new Actions(driver);
		WebElement aircraft = driver.findElement(By.xpath("//*[@id=\"RadMenubar_m2\"]"));
		action.moveToElement(aircraft).moveToElement(driver.findElement(By.xpath("//*[@id=\"RadMenubar_m2_m0\"]/span"))).build().perform();
		logger.log(Status.PASS, "Clicked on SubMenuLink");
		Thread.sleep(500);
		WebElement submenu1=  driver.findElement(By.linkText("Select..."));

		action.moveToElement(submenu1).click().build().perform();
		logger.log(Status.PASS, "Clicked on Select..");
	}

	@Test(priority=9)
	public void VerifyShowAllNone() throws InterruptedException {
		logger = extent.createTest("Verify show all Click","this will test the Show all Radio button");
		driver.switchTo().frame("DisplayWindow");
		logger.log(Status.PASS,"Switched the frmae");
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"ShowInLogsCheckBox\"]"));
		if(checkbox1.isSelected())
			checkbox1.click();
		logger.log(Status.PASS,"ShowInLogs Checkbox deselected");
		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"ShowAircraftNotInTimeFrameCheckBox\"]"));
		if(checkbox2.isSelected())
			checkbox2.click();
		logger.log(Status.PASS,"ShowAircraftNotInTimeFrame checkBox deslected ");
		driver.findElement(By.xpath("//*[@id=\"AllRadio\"]")).click();
		logger.log(Status.PASS,"Clicked on All Button");
		driver.findElement(By.xpath("//*[@id=\"Button5\"]")).click();
		logger.log(Status.PASS,"Clicked on OkButton");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='NoneRadio']")).click();
		logger.log(Status.PASS,"Clicked On None Button");
		driver.findElement(By.xpath("//*[@id=\"Button5\"]")).click();
		logger.log(Status.PASS,"Clicked On Ok Button");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		logger.log(Status.PASS,"Switched to Default Frame");
		WebElement ImageFile = driver.findElement(By.xpath("//*[@id=\"StatusControl\"]/div/img[2]"));

		Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
		if (!ImagePresent)
		{
			 System.out.println("when you click on none Image not displayed.");
		}
		else
		{
			System.out.println("when you click on none Image displayed.");
		}
		logger.log(Status.INFO,"Eye icon image status printed when you clicked NONE");
		
		driver.switchTo().frame("DisplayWindow");  
		logger.log(Status.PASS,"Switched to DisplayWindow Frame");
		driver.findElement(By.xpath("//*[@id=\"AllRadio\"]")).click();
		logger.log(Status.PASS,"Clicked on All Button");
		driver.findElement(By.xpath("//*[@id=\"Button5\"]")).click();
		logger.log(Status.PASS,"Clicked On Ok Button");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		logger.log(Status.PASS,"Switched to Default Frame");
		WebElement ImageFile2 = driver.findElement(By.xpath("//*[@id=\"StatusControl\"]/div/img[2]"));

		Boolean ImagePresent2 = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile2);
		if (!ImagePresent2)
		{
			System.out.println("when you click on All Image not displayed.");
		}
		else
		{
			System.out.println("when you click on All Image displayed.");
		}
		logger.log(Status.INFO,"Eye icon image status printed when you clicked ALL");
		
		driver.switchTo().frame("DisplayWindow");
		logger.log(Status.PASS,"Switched to DisplayWindow Frame");
		//   driver.findElement(By.xpath("//*[@id=\"Button1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"SelectedRadio\"]")).click();
		logger.log(Status.PASS,"Clicked On Selected Button");

		WebElement checkbox3 = driver.findElement(By.xpath("//input[@id=\"ShowAircraftNotInTimeFrameCheckBox\"]"));
		if(!checkbox3.isSelected())
			checkbox3.click();
		logger.log(Status.PASS,"ShowAircraftNotInTimeFrame checkBox slected ");
		driver.findElement(By.xpath("//*[@id=\"AllRadio\"]")).click();
		logger.log(Status.PASS,"Clicked on All Button");
		driver.findElement(By.xpath("//*[@id=\"Button5\"]")).click();
		logger.log(Status.PASS,"Clicked On Ok Button");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='NoneRadio']")).click();
		logger.log(Status.PASS,"Clicked On None Button");
		driver.findElement(By.xpath("//*[@id=\"Button5\"]")).click();
		logger.log(Status.PASS,"Clicked On Ok Button");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"Button1\"]")).click();
		logger.log(Status.PASS,"Clicked On Apply Button");
		driver.switchTo().defaultContent();

		VerifyAircraft();
		driver.switchTo().frame("DisplayWindow");
		logger.log(Status.PASS,"Switched to DisplayWindow Frame");
		driver.findElement(By.xpath("//*[@id=\"AllRadio\"]")).click(); 
		logger.log(Status.PASS,"Clicked on All Button");
		driver.findElement(By.xpath("//*[@id=\"Button1\"]")).click();
		logger.log(Status.PASS,"Clicked On Apply Button");
		driver.switchTo().defaultContent(); 
	}

	@Test(priority=10)
	public void VerifyShowHidden() throws InterruptedException {
		
		driver.switchTo().defaultContent();
		VerifyAircraft();
		driver.switchTo().frame("DisplayWindow");
		driver.findElement(By.xpath("//*[@id=\"SelectedRadio\"]")).click();
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/fieldset/div/div/table/tbody/tr/td[1]/select/option[6]")).click();
		driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/fieldset/div/div/table/tbody/tr/td[2]/input[2]")).click();
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"ShowAircraftNotInTimeFrameCheckBox\"]"));
		if(checkbox1.isSelected())
			checkbox1.click();

		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"ShowInLogsCheckBox\"]"));
		if(!checkbox2.isSelected()) {
			checkbox2.click();
		}

		else {

			driver.findElement(By.xpath("//*[@id=\"Button5\"]")).click();
		}
		Thread.sleep(5000);

		WebElement checkbox4 = driver.findElement(By.xpath("//*[@id=\"ShowInLogsCheckBox\"]"));
		if(checkbox4.isSelected())
			checkbox4.click();

		WebElement checkbox3 = driver.findElement(By.xpath("//*[@id=\"ShowAircraftNotInTimeFrameCheckBox\"]"));
		if(!checkbox3.isSelected()) {
			checkbox3.click();
		}


		else	{
			driver.findElement(By.xpath("//*[@id=\"Button5\"]")).click();
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"AllRadio\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"Button1\"]")).click();
		driver.switchTo().defaultContent();

		//		checkbox1.click();
		//	driver.findElement(By.xpath("//*[@id=\"Button5\"]")).click();
	}
	@Test(priority=11)
	public void ShowSelected() throws InterruptedException {

		//	driver.switchTo().defaultContent();
		VerifyAircraft();
		driver.switchTo().frame("DisplayWindow");

		driver.findElement(By.xpath("//*[@id=\"SelectedRadio\"]")).click();
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"ShowInLogsCheckBox\"]"));
		if(checkbox1.isSelected())
			checkbox1.click();

		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"ShowAircraftNotInTimeFrameCheckBox\"]"));
		if(checkbox2.isSelected())
			checkbox2.click();
		WebElement txt = driver.findElement(By.xpath("/html/body/form/div[3]/div[2]/fieldset/div/div/table/tbody/tr/td[3]/select/option[4]"));
		String chktxt = txt.getText();
		txt.click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"SkyTrac_Controls_0\"]/table/tbody/tr/td[2]/input[3]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"Button5\"]")).click();

		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		if(driver.getPageSource().contains(chktxt)){
			System.out.println("Text is present");
		}else{
			System.out.println("Text is absent");
		}
		Thread.sleep(2000);
		driver.switchTo().frame("DisplayWindow");
		driver.findElement(By.xpath("//*[@id=\"Button1\"]")).click();
		driver.switchTo().defaultContent();
		Actions action = new Actions(driver);
		WebElement aircraft = driver.findElement(By.xpath("//*[@id=\"RadMenubar_m2\"]"));
		action.moveToElement(aircraft).moveToElement(driver.findElement(By.xpath("//*[@id=\"RadMenubar_m2_m0\"]/span"))).build().perform();
		Thread.sleep(500);
		WebElement name = driver.findElement(By.xpath("//*[@id=\"RadMenubar_m2_m0_m2\"]/span"));

		assertEquals(name.isEnabled(),true);
	}

	@Test(priority=12)
	public void UnitvisibilitySanity() throws InterruptedException {
		VerifyAircraft();
		driver.switchTo().frame("DisplayWindow");
		WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"ShowInLogsCheckBox\"]"));
		if(!checkbox1.isSelected())
			checkbox1.click();

		WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"ShowAircraftNotInTimeFrameCheckBox\"]"));
		if(!checkbox2.isSelected())
			checkbox2.click();
		driver.findElement(By.xpath("//*[@id=\"OnGroundRadio\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"Button5\"]")).click();
		driver.switchTo().defaultContent();
		WebElement ImageFile2 = driver.findElement(By.xpath("//*[@id=\"StatusControl\"]/div/img[2]"));

		Boolean ImagePresent2 = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile2);
		if (!ImagePresent2)
		{
			System.out.println("On OnGround Image not displayed.");
		}
		else
		{
			System.out.println("On OnGround Image displayed.");
		}
		driver.switchTo().frame("DisplayWindow");
		driver.findElement(By.xpath("//*[@id=\"InFlightRadio\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"Button5\"]")).click();
		driver.switchTo().defaultContent();
		WebElement ImageFile3 = driver.findElement(By.xpath("//*[@id=\"StatusControl\"]/div/img[2]"));

		Boolean ImagePresent3 = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile3);
		if (!ImagePresent3)
		{
			System.out.println(" On InFlight Image not displayed.");
		}
		else
		{
			System.out.println("On InFlight Image displayed.");
		}
		driver.switchTo().frame("DisplayWindow");
		driver.findElement(By.xpath("//*[@id=\"PoweredUpRadio\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"Button5\"]")).click();
		driver.switchTo().defaultContent();
		WebElement ImageFile4 = driver.findElement(By.xpath("//*[@id=\"StatusControl\"]/div/img[2]"));

		Boolean ImagePresent4 = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile4);
		if (!ImagePresent4)
		{
			System.out.println("On PowerUp Image not displayed.");
		}
		else
		{
			System.out.println("On PowerUp Image displayed.");
		}
		driver.switchTo().frame("DisplayWindow");
		driver.findElement(By.xpath("//*[@id=\"PoweredDownRadio\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"Button5\"]")).click();
		driver.switchTo().defaultContent();
		WebElement ImageFile5 = driver.findElement(By.xpath("//*[@id=\"StatusControl\"]/div/img[2]"));

		Boolean ImagePresent5 = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile5);
		if (!ImagePresent5)
		{
			System.out.println("On PowerDown Image not displayed.");
		}
		else
		{
			System.out.println("On PowerDown Image displayed.");
		}
		driver.switchTo().frame("DisplayWindow");
		driver.findElement(By.xpath("//*[@id=\"Button1\"]")).click(); 
	}


}


