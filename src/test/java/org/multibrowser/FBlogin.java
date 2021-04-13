package org.multibrowser;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBlogin extends BaseClass{
	public FBlogin() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	public static WebElement username;
	@FindBy(id="pass")
	public static WebElement password;
	@FindBy(name="login")
	public static WebElement login;
	public static WebElement getUsername() {
		return username;
	}
	public static WebElement getPassword() {
		return password;
	}
	public static WebElement getLogin() {
		return login;
	}

}
