package Listener;

import ExtentReports.ExtentService;
import ExtentReports.ExtentTestManager;
import com.aventstack.extentreports.AnalysisStrategy;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentITestListenerClassAdapter implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ExtentService.getInstance().setAnalysisStrategy(AnalysisStrategy.CLASS);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentService.getInstance().flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.createMethod(result, true);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.log(result, true);
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        ExtentTestManager.log(result,  true);
    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        if (result.wasRetried()) {
            ExtentService.getInstance().removeTest(result.getName());
        } else
            ExtentTestManager.log(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

}