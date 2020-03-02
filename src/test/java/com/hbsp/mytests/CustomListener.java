package com.hbsp.mytests;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends BaseTest implements ITestListener{@Override

	
	
	public void onTestFailure(ITestResult result) {
	// TODO Auto-generated method stub
	
	System.out.println("Failed Tests");
	failed();
	
}

}
