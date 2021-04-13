package org.multibrowser;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Facebook extends BaseClass {	
	@Parameters("browsername")
	@BeforeClass
	private void BeforeClass(String name) {
		if(name.equals("chrome")) {
			launchBrowser("chrome");
		}
		else if (name.equals("firefox")) {
			launchBrowser("firefox");
		}
		else if (name.equals("ie")) {
			launchBrowser("ie");
		}
		else {
			System.out.println("Invalid Browser");
		}
		System.out.println("Before Class");
	}
	@Test
	private void test() {
		launchURL("https://www.facebook.com/");
		FBlogin fb=new FBlogin();
		FillTextBox(fb.getUsername(),"vinoht");
		FillTextBox(fb.getPassword(),"kumar678789");
		fb.btnclick(fb.login);

	}

}


