package org.facepojo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFacebookPojo {
	

	@FindBy(id="email")
	public static WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	public static WebElement password;

	@FindBy(xpath="//button[text()='Log in']")
	public static WebElement btnlogin;
	
	@FindBy(xpath="(//a[@role='button'])[2]")
	public static WebElement newacc;


}
