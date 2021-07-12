package com.MyTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.myPages.BasePage;
import com.myPages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	//we have to pass the driver to the "page Class constructor" then only it will supply to all the pages
	// so that all the driver is given to base page (i.e. this.driver") & then to login page
	public Page page;
	public static Properties prop;
	
	
	public BaseTest(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:/GEO/Selenium Sample/OOPsConcept/src/main/java/com/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	@BeforeMethod
	// getting browser from testng
	@Parameters(value={"browser"})
	public void setUpTest(String browser){
		if(browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		if(browser.equals("ff")){
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();
			
		}
		else{
			System.out.println("no browser found...");
		}
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*now we have to call constructor of page class
		 * now cannot create object 
		 * like , page = new Page();
		 * because it is abstract class now for that to call constructor of page class we have to use 
		 * with the help of Child class of the PageClass of the abstract class.
		 */
		page = new BasePage(driver);
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
