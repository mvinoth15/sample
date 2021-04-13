package org.paralleltest;

import org.testng.annotations.Test;

public class B {
	@Test
	private void TestA1() {
System.out.println("TestA1");
System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void TestA2() {
System.out.println("TestA2");
System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void TestA3() {
System.out.println("TestA3");
System.out.println(Thread.currentThread().getId());
	}

}
