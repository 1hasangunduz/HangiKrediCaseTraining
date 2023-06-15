package HangiKrediPages;

import BasePages.BaseTest;
import Data.GetData;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@Listeners({Listener.ExtentITestListenerClassAdapter.class})
public class HomePageTests extends BaseTest {


    @Test
    public void controlCreditTabHoverElement() throws InterruptedException {
        setupTest("chrome");
        new HomePage()
                .navigateToUrl(GetData.URL.MASTER.value)
                .hoverCredit()
                .controlCreditElement()
        ;
    }


    //Data Provider, Parameters veya bu bicimde de yonetilebilir.
    @Test
    @Parameters({"url"})
    public void controlResponseCode(@Optional("https://www.hangikredi.com/kredi/ihtiyac-kredisi") String url) {
        setupTest("chrome");
        new HomePage()
                .postRequest(url)
        ;
    }

    @Test
    public void controlResponseCode() {
        setupTest("chrome");
        new HomePage()
                .postRequest(GetData.URL.PERSONAL_FINANCE_CREDIT.value)
        ;
    }

    @Test
    @Parameters({"loanTerm"})
    public void controlCreditSuggestion(@Optional("12") String loanTerm) throws InterruptedException {
        setupTest("chrome");
        new HomePage()
                .navigateToUrl(GetData.URL.PERSONAL_FINANCE_CREDIT.value)
                .controlCreditSuggestions(loanTerm)
        ;
    }

    @Test
    @Parameters({"browser", "loanTerm"})
    public void controlSponsorBankSuggestion(
            @Optional("chrome") String browser, @Optional("12") String loanTerm) throws InterruptedException {
        setupTest(browser);
        new HomePage()
                .navigateToUrl(GetData.URL.PERSONAL_FINANCE_CREDIT.value)
                .controlCreditSuggestions(loanTerm)
                .controlSponsorBankDetails()
        ;
    }


}
