package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import org.apache.logging.log4j.LogManager;//log4j
//import org.apache.logging.log4j.Logger;   //log4j


public class BaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException{
		
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		
		switch(br.toLowerCase()) {
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		case "firefox" : driver=new FirefoxDriver(); break;
		default : System.out.println("Invalid Browser Name"); return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("appURL")); //reading url from properties file
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	
	
	public String randomString() {
		String randmStr=RandomStringUtils.randomAlphabetic(5);
		return randmStr;
	}
	
	public String randomNumber() {
		String randmNum=RandomStringUtils.randomNumeric(10);
		return randmNum;
	}
	
	public String randmAlphaNumeric() {
		String randmStr=RandomStringUtils.randomAlphabetic(3);
		String randmNum=RandomStringUtils.randomNumeric(3);
		
		return (randmStr+"@"+randmNum);
	}

}
