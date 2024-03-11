package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Screenshot {


	
	public void takeFullScreenShot(String name,WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String file_path=System.getProperty("user.dir")+"\\screenshots\\"+name+".png";
		File trg=new File(file_path);
		FileUtils.copyFile(src, trg);
		
	}
	public void takeSectionScreenshot(String name,WebElement section) throws IOException {
		
		File src=section.getScreenshotAs(OutputType.FILE);
		String file_path=System.getProperty("user.dir")+"\\screenshots\\"+name+".png";
		File trg=new File(file_path);
		FileUtils.copyFile(src, trg);
		
	}
	
}
