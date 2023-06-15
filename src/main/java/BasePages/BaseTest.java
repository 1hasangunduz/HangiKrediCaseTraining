package BasePages;

import ExtentReports.ExtentTestManager;
import Listener.Listener;
import Utilities.Log;
import com.aventstack.extentreports.Status;
import org.testng.annotations.*;

import java.time.Duration;

import static BasePages.DriverManager.setDriver;



@Listeners({Listener.class})
public class BaseTest {

    public static void setupTest(String browser) {
        setDriver(browser);
        Log.pass("Window size: " + DriverManager.getDriver().manage().window().getSize());
        ExtentTestManager.getTest().log(Status.PASS, "Window size: " + DriverManager.getDriver().manage().window().getSize());
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (DriverManager.getDriver() != null) {
            DriverManager.getDriver().quit();
        }
    }
}