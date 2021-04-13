package org.paralleltest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample {
	@Test
	private void A1() {
Assert.assertTrue(true);
System.out.println("A1");
	}
	@Test
	private void A2() {
Assert.assertTrue(false);
System.out.println("A2");
	}
	@Test
	private void A3() {
Assert.assertTrue(true);
System.out.println("A3");
	}

}
