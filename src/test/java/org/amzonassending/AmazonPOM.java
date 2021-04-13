package org.amzonassending;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPOM extends BaseClass{
	
	public AmazonPOM() {
PageFactory.initElements(driver, this);
	}
	@FindBy(id="twotabsearchtextbox")
	public WebElement SearchBox;
	@FindBy(id="nav-search-submit-button")
	public WebElement SearchEnter;
	public WebElement getSearchBox() {
		return SearchBox;
	}
	public WebElement getSearchEnter() {
		return SearchEnter;
	}
}
