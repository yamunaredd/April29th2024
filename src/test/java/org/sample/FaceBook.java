package org.sample;

import java.util.Date;

import org.facepojo.LoginFacebookPojo;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class FaceBook extends BaseClass{
	

	@BeforeMethod
	private void startTime() {
		Date d = new Date();
		System.out.println(d);

	}
	
	@Parameters({ "email1", "password1"})
	@Test
	private void tc1(@Optional("jiya123@gmail.com")String user1, @Optional("jiya123")String pass1) {

		loadUrl("https://www.facebook.com/");
		String y = pageTitle();
		PageFactory.initElements(driver, LoginFacebookPojo.class);
		
		LoginFacebookPojo l = new LoginFacebookPojo();	
		passText(l.username, user1);
		passText(l.password, pass1);
		buttonLogin(l.btnlogin);
				
	}

	@BeforeClass
	private void preCondition() {
		browserLaunch();
		maxBrowser();
		
	}
	
	@AfterMethod
	private void endTime() {
		Date d = new Date();
		System.out.println(d);

	}
	
	@AfterClass
	private void postCondition() {
		pageClose();
		System.out.println("closed");
	}
	
	@Parameters({ "email1", "password1" })
	@Test
	private void tc6(@Optional("jiya123@gmail.com")String user2, @Optional("jiya123")String pass2) {

		loadUrl("https://www.facebook.com/");	
		PageFactory.initElements(driver, LoginFacebookPojo.class);
		String y = pageTitle();
		LoginFacebookPojo l = new LoginFacebookPojo();	
		passText(l.username, user2);
		passText(l.password, pass2);
		SoftAssert s = new SoftAssert();
		s.assertEquals("Facebook",y,"check your title");
//		buttonLogin(l.btnlogin);
				
	}

	@Parameters({ "email3", "password3" })
	@Test
	private void tc4(@Optional("jiya123@gmail.com")String user3, @Optional("jiya123")String pass3) {

		loadUrl("https://www.facebook.com/");	
		PageFactory.initElements(driver, LoginFacebookPojo.class);
		
		LoginFacebookPojo l = new LoginFacebookPojo();	
		passText(l.username, user3);
		passText(l.password, pass3);
//		buttonLogin(l.btnlogin);
		
	}
	
	@Test(dataProvider="datas")
	private void tc7(String user4, String pass4) {

		loadUrl("https://www.facebook.com/");	
		PageFactory.initElements(driver, LoginFacebookPojo.class);
		
		LoginFacebookPojo l = new LoginFacebookPojo();	
		passText(l.username, user4);
		passText(l.password, pass4);
//		buttonLogin(l.btnlogin);
		
	}
	
	@DataProvider(name="datas")
	private Object[][] getData(){
		return new Object[][] {
		
			{"kavi123@gmail.com", "kavi123"},
			{"abi123@gmail.com", "abi123"},
			{"siva123@gmail.com", "siva123"},
			{"ram123@gmail.com", "ram123"},
			{"",""}
			
		};
		
	}

}
