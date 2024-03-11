package testCases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.FeaturedNews;


public class TC_004_ToolTip extends TC_003_AppsTools{
	
	@Test(priority=5)
	public void verify_Tooltip_Headlines() throws InterruptedException {
		logger.info("***** TC_004_verification of ToolTips starting *****");
		try {
		
		FeaturedNews fns=new FeaturedNews(driver);
		
		List<WebElement> newsheadlines=fns.news_anchor;
		
		SoftAssert softassertion=new SoftAssert();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));

		for(WebElement item:newsheadlines) {
			

			
			
			wait.until(ExpectedConditions.visibilityOf(item));
			System.out.println(item.getAttribute("title"));
			softassertion.assertEquals(item.getAttribute("title"),item.getText());
		}
		
		softassertion.assertAll();
		logger.info("***** TC_004_verification of ToolTips finished *****");
	}catch(Exception e) {
		logger.error("Tooltip verification failed-----");
		
	}
	
	}

}
