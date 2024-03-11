package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AppsAndTools;
import utilities.Screenshot;


public class TC_003_AppsTools extends TC_002_FetchingNews{
	
	
	@Test(priority=3)
	public void verify_appAndToolHeader() throws InterruptedException {
		logger.info("*****TC_003_Verification of Apps and Tools starting*****");
		try {
			
			AppsAndTools apt= new AppsAndTools(driver);
			
			String expt_header="Apps and Tools";
			String act_header=apt.getAppsAndToolsHeader();
			Assert.assertEquals(expt_header, act_header);
		}catch(Exception e) {
			logger.error("Apps and Tools header verification failed");
		}
		
		
	}
	@Test(priority=4)
	
	public void printAppsTools() throws InterruptedException, IOException {
		try {
		AppsAndTools ap= new AppsAndTools(driver);
		Screenshot ss=new Screenshot();
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(3));
		mywait.until(ExpectedConditions.visibilityOf(ap.moreAppTools));
		ap.moreAppTools.click();
		
		logger.info("Clicking on more section of apps and tools");
		
		
		ss.takeFullScreenShot("App and Tools", driver);
		for(WebElement app:ap.appList) {
			
			mywait.until(ExpectedConditions.visibilityOf(app));
			logger.info("Blogs are being fetched");
			System.out.println(app.getText());
			System.out.println("==================================================");
			Thread.sleep(1000);
		}
		logger.info("*****TC_003_Verification of Apps and Tools finished*****");
		}catch(Exception e) {
			logger.info("TC_003 FAILED");
		}
	}
}
