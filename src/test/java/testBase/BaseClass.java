package testBase;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;//log4j

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	

	public WebDriver driver;
	public Logger logger;
	public Properties prop;
	@BeforeTest
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException {
		
		
		
		//load properties file
		FileReader file =new FileReader(".//src/test/resources/config.properties");
		prop=new Properties();
		prop.load(file);
		
		//loading log4j2 file
		logger=LogManager.getLogger(this.getClass());
		
		
		switch(br.toLowerCase()) {
		case "chrome":driver =new ChromeDriver();break;
		case "edge" :driver=new EdgeDriver();break;
		default:System.out.println("No matching browser....");return;
		
		}
		
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("appUrl"));
		
		driver.manage().window().maximize();
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
