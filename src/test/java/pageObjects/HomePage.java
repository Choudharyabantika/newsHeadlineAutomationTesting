package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	WebDriver driver;
	
	//passing the same driver to the parent class
	public HomePage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='O365_MainLink_MePhoto']")
	WebElement MyAccount;
	
	@FindBy(xpath="//div[@class='mectrl_accountDetails']//div[@id='mectrl_currentAccount_primary']")
	WebElement UserName;
	
	@FindBy(xpath="//div[@class='mectrl_accountDetails']//div[@id='mectrl_currentAccount_secondary']")
	WebElement mail;
	
	
	public void clickMyAccount() {
		MyAccount.click();
	}
	
	
	public String getUsername() {
		try {
			return UserName.getText();
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	public String getmail() {
		try {
			
			return mail.getText();
		}catch(Exception e) {
			return (e.getMessage());
		}
	}
	

}
