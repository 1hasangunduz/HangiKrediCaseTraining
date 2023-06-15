package Listener;


import ExtentReports.ExtentService;
import ExtentReports.ExtentTestManager;
import com.aventstack.extentreports.AnalysisStrategy;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentITestListenerAdapter implements ITestListener {

    @Override
    public synchronized void onStart(ITestContext context) {
        ExtentService.getInstance().setAnalysisStrategy(AnalysisStrategy.TEST);
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        ExtentService.getInstance().flush();
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        ExtentTestManager.createMethod(result);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        ExtentTestManager.log(result);
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        ExtentTestManager.log(result);

    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        if (result.wasRetried()) {
            ExtentService.getInstance().removeTest(result.getName());
        } else
            ExtentTestManager.log(result);
    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }
}