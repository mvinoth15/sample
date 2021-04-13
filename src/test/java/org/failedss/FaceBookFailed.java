package org.failedss;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FaceBookFailed extends BaseClass {
	@BeforeClass
	private void base() {
launchBrowser("chrome");
	}
	@Test
	private void test() {
System.out.println("TestA1");
launchURL("https://www.facebook.com/");
FBlogin fb=new FBlogin();
FillTextBox(fb.getUsername(), "vinoth");
FillTextBox(fb.getPassword(), "1323256");
fb.btnclick(fb.login);
Assert.assertTrue(false);
	}
	
}
