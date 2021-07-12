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
public class LoginPage extends BasePage {
// contructior is added
	
	
	//PagelLocators
	
	//declare with private to acheive encapsulation, not want expose out of the class
	
	private By Email = By.name("Email");
	private By Password = By.name("Password");
	private By LoginBtn = By.xpath("//button[contains(text(),'Log in')]");
	private By header = By.xpath("//strong[contains(text(),'Returning Customer')]");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//getters 
	/**
	 * @return the email
	 * changed BY to Webelement because sendkeys will be in webelement & not By locators
	 * WebElement will inherit from basePage class without creating object
	 */
	public WebElement getEmail() {
		return getElement(Email);
	}

	

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(Password);
	}

	
	/**
	 * @return the loginBtn
	 */
	public WebElement getLoginBtn() {
		return getElement(LoginBtn);
	}

	

	/**
	 * @return the header
	 */
	public WebElement getHeader() {
		return getElement(header);
	}
	
	
	//generic method is created on Basepage class
	public String getLoginPageTitle(){
		return getPageTitle();
	}
	
	public String getLoginPageHeader(){
		return getPageHeader(header);
	}

	/**
	 * 
	 * @param Email
	 * @param Password
	 * @return
	 * 
	 * 2 method with parameter & no parameter is called 
	 * Method overloading shown below
	 */
	public HomePage doLogin(String Email, String Password){
		getEmail().sendKeys(Email);
		getPassword().sendKeys(Password);
		getLoginBtn().click();
		
		// after login it will show Home page so use return
		return getInstance(HomePage.class);
	}

	/**
	 * 
	 * @return
	 */
	// Negative test by method overloading
	
	public void doLogin(){
		getEmail().sendKeys("");
		getPassword().sendKeys("");
		getLoginBtn().click();
		//nothing to return
	}
	
	// user: geo@mailinator.com - this is how it will append
	//can be used in other way in if..else statement 
/*	public void doLogin(String user, String pwd){
		if(user.contains("email")){
			getEmail().sendKeys(user.split(":")[1].trim());
			
		} else if(pwd.contains("pwd")){
			getEmail().sendKeys(user.split(":")[1].trim());
			
	}
		getLoginBtn().click();
	}
	*/
	
	}

