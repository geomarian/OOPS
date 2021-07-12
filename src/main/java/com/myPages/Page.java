package com.myPages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	WebDriver driver;
	WebDriverWait wait;
	
	//taking only 1 variable i.e. driver
	public Page(WebDriver driver){
		this.driver=driver;
		//for wait we need driver
		this.wait= new WebDriverWait(this.driver,15);	
		
	}
	
	//abstract methods
	
	/*- here every page should have abstract methods
	in abstract method type code is not allowerd 
	ed: public void GetMmm(){
		 } */
	public abstract String getPageTitle();
	
	
	//every page should have this header
	public abstract String getPageHeader(By locator);
	
	//we will get eleemnt in runtime- it will return webelement
	public abstract WebElement getElement(By locator);
	
	
	//here we are not returning anything so used void
	public abstract void waitForElementPresent(By locator);
	
	
	public abstract void waitForElementTitle(String title);
	
	
	
	// GEnerics
										// it will return page instance
	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass){
	
	
	try {
		/*At the runtime,
		Whatever the page class is passing (ex: homepage/loginpage, it check below constructor
				 and  get the Webdriver instance and creating object of that particular class instead of writing
				 page (ex: login page page = new login page) so instead of new keyword, it uses new instance
				 
				 (excatly representing the constructor
				 */
		
		return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
}
}
