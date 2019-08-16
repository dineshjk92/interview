package com.gogo.interview.core;

/**
 * @author cb-dinesh
 *
 */

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;

/**
 * A listener for test running
 * This class listens to TestNG Suite level and Test level actions
 */
public class TestNGListener implements ITestListener, ISuiteListener {
	
	Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

	@Override
	public void onStart(ISuite suite) {
		logger.info("XML FileName : " + suite.getXmlSuite().getFileName());
		logger.info("Executing the Suite : " + suite.getName());
	}
	
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Executing the Test : " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test PASSED : " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test FAILED : " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test SKIPPED : " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
}
