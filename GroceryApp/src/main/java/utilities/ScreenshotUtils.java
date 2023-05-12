package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtils {
	public void captureScreenshotFailures(WebDriver driver,String image) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);// screenshot will store in temporary path
		String timestamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss"). format(new Date()); 
		
		File reportPath=new File(System.getProperty("user.dir")+"//ScreenshotImages");

		if(!reportPath.exists()) {
		reportPath.mkdir();
		}
		File finalDestination = new File(System.getProperty("user.dir")+"\\ScreenshotImages\\"+image+timestamp+".png");
		FileHandler.copy(screenShot, finalDestination);

	}

}
