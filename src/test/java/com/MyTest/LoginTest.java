package com.MyTest;

import org.testng.annotations.Test;

import com.myPages.HomePage;
import com.myPages.LoginPage;

import org.testng.Assert;

public class LoginTest extends BaseTest{

	@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		/*
		 * we can call it by login page page = new login page()
		 * but it is not nice so we need to use generic
		 
		 *
		 * Page is coming from BaseTest so that we can inherit
		 * this page class reference in login test
		 */
		
		//we are storing in String so
		String title = page.getInstance(LoginPage.class).getLoginPageTitle();
		System.out.println("title = ");
		Assert.assertEquals(title, "Welcome, Please Sign In!");
	}
	
	@Test(priority=2)
	public void verifyLoginPageHeader(){
		
		String header = page.getInstance(LoginPage.class).getLoginPageHeader();
		System.out.println("title = ");
		Assert.assertEquals(header, "Returning Customer");
	}
	
	@Test(priority=3)
	public void doLoginTest(){
		//after login it will show homepage so used homepage = 
		HomePage homepage = page.getInstance(LoginPage.class).doLogin(prop.getProperty("Email"), prop.getProperty("Password"));
		homepage.getHomePageHeader();
		String headerHome = homepage.getHomePageHeader();
		System.out.println(headerHome);
		Assert.assertEquals(headerHome, "Welcome to our store");
	}
}
