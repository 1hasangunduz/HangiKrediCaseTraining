package HangiKrediPages;

import BasePages.BaseTest;
import Data.GetData;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class HomePageTests extends BaseTest {


    @Test
    public void controlCreditTabHoverElement() throws InterruptedException {
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
        new HomePage()
                .postRequest(url)
        ;
    }

    @Test
    public void controlResponseCode() {
        new HomePage()
                .postRequest(GetData.URL.PERSONAL_FINANCE_CREDIT.value)
        ;
    }

    @Test
    @Parameters({"loanTerm"})
    public void controlCreditSuggestion(@Optional("12") String loanTerm) throws InterruptedException {
        new HomePage()
                .navigateToUrl(GetData.URL.PERSONAL_FINANCE_CREDIT.value)
                .controlCreditSuggestions(loanTerm)
        ;
    }

    @Test
    @Parameters({"loanTerm"})
    public void controlSponsorBankSuggestion(@Optional("12") String loanTerm) throws InterruptedException {
        new HomePage()
                .navigateToUrl(GetData.URL.PERSONAL_FINANCE_CREDIT.value)
                .controlCreditSuggestions(loanTerm)
                .controlSponsorBankDetails()
        ;
    }

}
