package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppsAndTools  extends BasePage{
	WebDriver driver;
	
	public AppsAndTools(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="(//span[@data-automation-id='webPartTitleReadMode'])[2]")
	WebElement appToolsHeader;
	
	@FindBy(xpath="//div[text()='All Apps & Tools']")
	public
	WebElement moreAppTools;
	@FindBy(xpath="//div[@data-automation-id='textBox']//ul//parent::div")
	public
	List<WebElement> appList;
	
	
	public String getAppsAndToolsHeader() throws InterruptedException {
		
		
		return appToolsHeader.getText();
	}
	

}
