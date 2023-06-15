package Listener;

import BasePages.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(Listener.class);

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }


    @Override
    public void onStart(ITestContext iTestContext) {
        LOGGER.info("I am in onStart method " + iTestContext.getName());

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOGGER.info("I am in onFinish method " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("Test Started: " + getTestMethodName(iTestResult));
    }


    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info(getTestMethodName(iTestResult) + " test is succeed.");
        //ExtentReports log operation for passed tests.
        // getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.info("Test Failed: " + getTestMethodName(iTestResult));
        LOGGER.error(iTestResult.getThrowable());
        //LOGGER.info(DriverManager.getDriver().getCurrentUrl());


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info("Test Skipped: " + getTestMethodName(iTestResult));
        //ExtentReports log operation for skipped tests.
        //getTest().log(Status.SKIP, "Test Skipped");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LOGGER.info("Test Failed Within Success Percentage: " + getTestMethodName(iTestResult));
    }


}