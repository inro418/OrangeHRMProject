package utils;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ESS {

	WebDriver driver;
	private static Logger logger = LogManager.getLogger();

    @BeforeTest 
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\koree\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Test
	public void verifyESS() throws InterruptedException {  
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		logger.info("Enter username");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");    
		logger.info("Enter password");
		
		Thread.sleep(3000);
		driver.findElement(By.id("btnLogin")).click();
		logger.info("Click Login button");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='My Info']")).click();
		logger.info("Click Myinfo tab"); 
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='button'])[4]")).click();
		logger.info("Click edit"); 
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();  
		logger.info("Click save");  
		
        driver.quit();
        logger.info("Close browser");  
	}
}
