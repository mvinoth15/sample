package org.failedtest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(WithoutKnown.class)
public class FailedTest extends BaseClass{

	@Test
	private void TestA1() {
		Assert.assertTrue(true);
		System.out.println("TestA1");
	}
	@Test
	private void TestA2() {
		System.out.println("testA2");
	}
	@Test()//retryAnalyzer=WithKnown.class
	private void testA3() {
		Assert.assertTrue(false);
		System.out.println("testA3");
	}
	@Test
	private void testA4() {
		System.out.println("testA4");
	}
}
