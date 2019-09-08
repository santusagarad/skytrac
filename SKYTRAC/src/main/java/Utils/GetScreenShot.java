package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenShot {
 public static WebDriver driver;
	public static void main(String[] args) {
		 ScreenShot();
	}

	
	public static void ScreenShot() {
		File srcshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			String path = System.getProperty("User.dir");	
			FileUtils.copyFile(srcshot, new File(path+"\\ScreenShots/Polling"+System.currentTimeMillis()+".png"));
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
  
		} 
	}
}
  


   