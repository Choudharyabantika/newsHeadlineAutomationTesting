package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.FeaturedNews;

import utilities.Screenshot;


public class TC_002_FetchingNews extends TC_001_AccountConfirmationTest{
	
	
	
	@Test(priority=2)

	public void fetchingNews() throws InterruptedException, IOException {
		logger.info("***** TC_002_FetchingNews starting *****");
	
		FeaturedNews fnp=new FeaturedNews(driver);
		Screenshot ss=new Screenshot();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		for(int i=0;i<fnp.news.size()-1;i++) {
			
			
			fnp.news.get(i).click();
			logger.info("clicking on the link in the featured news section");
			
			Thread.sleep(2000);
			
			ss.takeFullScreenShot("News"+i, driver);
			
			Thread.sleep(3000);
		
			
			//heading of the news
			logger.info("Fetching heading of the news");
			wait.until(ExpectedConditions.visibilityOf(fnp.news_title));
			String title=fnp.news_title.getText();
//			Thread.sleep(2000);
				
				
			//author of the news
			logger.info("Fetching the author of the news");
			
			wait.until(ExpectedConditions.visibilityOf(fnp.author));
			String author_news=fnp.author.getText();
			Thread.sleep(2000);
			
			//fetching the news article
			logger.info("Fetching the news article");
			wait.until(ExpectedConditions.visibilityOf(fnp.news_body));
			String news_article=fnp.news_body.getText();
			
			logger.info("Printing the news in the console");
				
			System.out.println(" News Title: "+title);
			System.out.println(" Author details: "+author_news);
			System.out.println("====================================================");
			System.out.println(news_article);
			System.out.println("====================================================");
			logger.info("Navigating back to the be.cognizant main page");

			fnp.nav_beCognizant.click();
			
		}
	}
	
	@Test(priority=3)
	public void fetchingBlog() throws InterruptedException, IOException {
		
		
		FeaturedNews fp=new FeaturedNews(driver);
		Screenshot ss=new Screenshot();
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		fp.news.get(fp.news.size()-1).click();
		
//		Thread.sleep(2000);
	
		//heading of the news
		logger.info("Fetching heading of the blog");
		mywait.until(ExpectedConditions.visibilityOf(fp.news_title));
		String title=fp.news_title.getText();

		String blog_body;
		Thread.sleep(2000);
		System.out.println(" News Title: "+title);
		System.out.println("====================================================");
		for(int j=0;j<5;j++) 
			{	
			Thread.sleep(1000);
			
			ss.takeSectionScreenshot("blogs"+j,fp.blogs.get(j));
				
			mywait.until(ExpectedConditions.visibilityOf(fp.blogs.get(j)));
				blog_body=fp.blogs.get(j).getText();
				System.out.println(blog_body);
				System.out.println("====================================================");
			}
		logger.info("Navigating back to the be.cognizant main page");
		fp.nav_beCognizant.click();

		logger.info("***** TC_002_FetchingNews finished*****");
	}
	

}
