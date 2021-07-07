package findingpackageutil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import findinghospitals.HomePage;



public class CaptureScreenShot extends HomePage {

	 public void captureScreenShot() {
	        TakesScreenshot takescreenshot = (TakesScreenshot) driver;
	        File srcFile = takescreenshot.getScreenshotAs(OutputType.FILE);
	        File desFile = new File(System.getProperty("user.dir") + "//Screenshots//"+ DateUtil.getTimeStamp() + ".png");
	        try {
	            FileUtils.copyFile(srcFile, desFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
