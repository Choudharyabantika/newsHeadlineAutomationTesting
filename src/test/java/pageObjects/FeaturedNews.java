package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class FeaturedNews  extends BasePage{
	
	WebDriver driver;
	public FeaturedNews(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//div[@role='listitem']//div[@data-automation-id='newsItem']")
	public
	List<WebElement> news;
	
	@FindBy(xpath="//div[@role='listitem']//div[@data-automation-id='newsItem']//div[2]//a")
	public
	List<WebElement> news_anchor;
	@FindBy(xpath="//div[@data-automation-id='TitleTextId']")
	public
	WebElement news_title;
	@FindBy(xpath="//div[@data-automation-id='personaDetails']")
	public
	WebElement author;
	@FindBy(xpath="//div[@data-automation-id='CanvasLayout']")
	public
	WebElement news_body;
	@FindBy(xpath="//span[contains(text(),'be.cognizant')]")
	public
	WebElement nav_beCognizant;
	@FindBy(xpath="//div[@data-automation-id='textBox']")
	public
	List<WebElement> blogs;

	

	

}

