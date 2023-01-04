package HomePageCase;

import BasePages.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void testHomePage() {
       new HomePage()
               .navigateToUrl("https://www.enuygun.com/")
               .hoverCredit();
    }
}
