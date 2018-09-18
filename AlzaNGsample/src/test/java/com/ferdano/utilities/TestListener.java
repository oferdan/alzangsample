package com.ferdano.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

	public void onFinish(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		Log.endLog(iTestContext.getName()); //log end of class
	}

	public void onStart(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		Log.startLog(iTestContext.getName()); //log start of class
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		Log.error("Error: " +iTestResult);
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		Log.startMethodLog(getTestMethodName(iTestResult)); // log start of the method
	}

	public void onTestSuccess(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		Log.info("Passed: " +iTestResult);
	}

}
