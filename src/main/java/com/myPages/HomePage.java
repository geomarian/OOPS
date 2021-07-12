/**
 * 
 */
package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Geo
 *
 */
public class HomePage extends BasePage{
	private By header = By.xpath("//h2[contains(text(),'Welcome to our store')]");
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	//getter
	public WebElement getHeader() {
		return getElement(header);
	}
	
	public String getHomePageTitle() {
		return getPageTitle();
	}
	
	public String getHomePageHeader() {
		return getPageHeader(header);
	}

}
