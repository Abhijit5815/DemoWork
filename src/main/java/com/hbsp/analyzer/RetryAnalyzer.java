package com.hbsp.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	
	int counter=0;
	int retrylimit =0;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(counter < retrylimit)
		{
			counter ++;
			return true;
		}
		return false;
	}

}
 