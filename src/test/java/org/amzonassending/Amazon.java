package org.amzonassending;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;


public class Amazon extends BaseClass{
	@BeforeClass
	private void Browserlaunch() {
		launchBrowser("chrome");
		System.out.println("Browser Launched");
	}
	@Test
	private void AmazonPage() {
		launchURL("https://www.amazon.in/");
	}
	@Test
	private void AmazonValue() {
		AmazonPOM a=new AmazonPOM();
		FillTextBox(a.getSearchBox(),"iphones" );
		btnclick(a.getSearchEnter());
		//Set<String> s1=new TreeSet<>();
		List<WebElement> Apple = driver.findElements(By.xpath("//span[contains(text(),'Apple')]"));
	for(WebElement Apples:Apple) {
			System.out.println(Apples.getText().trim());
	}
	

		List<WebElement> ApplePrice = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		for (WebElement price : ApplePrice) {
			System.out.println(price.getText().trim());	
		}
		

	}
}
	




