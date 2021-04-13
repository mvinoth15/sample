package org.failedtest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class WithKnown implements IRetryAnalyzer{
int FailedCount=0, MaxCount=5;
	@Override
	public boolean retry(ITestResult result) {
if(FailedCount<MaxCount) {
	FailedCount++;
	return true;
}	
	return false;
	}

}
