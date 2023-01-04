package HangiKrediPages;

import BasePages.DriverManager;
import BasePages.SeleniumBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class HomePage extends SeleniumBasePage {


    @FindBy(xpath = "//*[@class='navigation']//*[@class='has_submenu']/a[@href='/kredi']")
    WebElement btnCredit;

    @FindBy(id = "amount")
    WebElement textAmount;

    @FindBy(id = "maturity")
    WebElement selectLoanTerm;

    @FindBy(id = "CalculateCta")
    WebElement btnCalculate;

    @FindBy(xpath = "//h2")
    WebElement textTitle;

    //bu alanların daha az bakım maliyeti cıkması icin testid verilmeli.
    @FindBy(xpath = "//*[@class='card-content']//*[@class='card__special-header']")
    WebElement titleSponsorBank;

    @FindBy(xpath = "//*[@class='card-content']//*[text()='Sponsor Banka']//parent::div[1]//parent::div//div[@class='interest-rate']//*[contains(@class, 'rates')]")
    WebElement txtInterestRate;
    @FindBy(xpath = "(//div[@class='pfc__details']//parent::dd)[1]")
    WebElement txtDetailsInterestRate;

    @FindBy(xpath = "//*[@class='card-content']//*[text()='Sponsor Banka']//parent::div[1]//parent::div//div[@class='monthly-installment']//*[contains(@class, 'rates')]")
    WebElement txtMonthlyInstallment;
    @FindBy(xpath = "(//div[@class='pfc__details']//parent::dd)[3]")
    WebElement getTxtDetailsInterestRate;

    @FindBy(xpath = "//*[@class='card-content']//*[text()='Sponsor Banka']//parent::div[1]//parent::div//div[@class='total-payment']//*[contains(@class, 'rates')]")
    WebElement txtTotalPayment;
    @FindBy(xpath = "(//div[@class='pfc__details']//parent::dd)[4]")
    WebElement txtDetailsTotalPayment;

    @FindBy(xpath = "//a[@class='detail']")
    WebElement btnDetail;

    @FindBy(xpath = " //*[@class='navigation']//*[@class='has_submenu']//a[contains(@href,'/kredi/')]")
    List<WebElement> hoverElementCredit;


    public HomePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }


    public HomePage navigateToUrl(String url) throws InterruptedException {
        DriverManager.getDriver().navigate().to(url);
        Thread.sleep(5000);
        System.out.println(url + "  --> Sayfasinda land olunacak.");

        return this;
    }

    public HomePage hoverCredit() throws InterruptedException {
        Thread.sleep(5000);
        scrollHover(btnCredit, "Kredi butonuna hover yapildi.");
        Thread.sleep(2000);
        return this;
    }

    public void controlCreditElement() {
        try {
            for (int i = 1; i <= hoverElementCredit.size(); i++) {
                List<WebElement> elem = DriverManager.getDriver().findElements(By.xpath("//*[@class='navigation']//*[@class='has_submenu']//a[contains(@href,'/kredi/')][" + i + "]"));
                if (!elem.isEmpty()) System.out.println(elem + " --> Element mevcut bir sekilde goruntulendi.");

            }
        } catch (Exception e) {
            System.err.println("Element bulunamadi");
        }
    }

    public void sendCreditPrice() throws InterruptedException {
        String number = Integer.toString(generateNumbers(500, 100000));
        System.out.println("Kredi tutari --> " + number);
        textAmount.sendKeys(number);
        Thread.sleep(2000);
        System.out.println("Kredi tutari " + textAmount.getText() + " girildi.");
        if (textAmount.getText().equals(number)) System.err.println("Kredi tutari yanlis girildi.");


    }

    public void selectLoanTerm(String loanTerm) throws InterruptedException {
        selectCombobox(selectLoanTerm, loanTerm);
        Thread.sleep(2000);
        System.out.println("Kredi vadesi secildi.");
    }

    public HomePage controlCreditSuggestions(String loanTerm) throws InterruptedException {
        sendCreditPrice();
        postRequest(DriverManager.getDriver().getCurrentUrl());
        selectLoanTerm(loanTerm);
        btnCalculate.click();
        System.out.println("Kredi hesapla butonuna tiklandi.");
        if (textTitle.isEnabled()) System.out.println("Kredi sonuclari goruntulendi.");
        else System.err.println("Kredi sonuclari goruntulenemedi.");
        return this;

    }

    public void controlSponsorBankDetails() throws InterruptedException {

        String interestRateText = txtInterestRate.getText();
        String monthlyInstallmentText = txtMonthlyInstallment.getText();
        String totalPaymentText = txtTotalPayment.getText();
        System.out.println("Sponsor banka detaylari goruntulendi ; " + " Faiz orani --> " + interestRateText + " Aylik Taksit -->" + monthlyInstallmentText + "Toplam Odeme --> " + totalPaymentText);
        btnDetail.click();
        System.out.println("Detaylar butonuna tiklandi.");
        Thread.sleep(2000);
        compareWebElementText(interestRateText, txtDetailsInterestRate.getText());
        compareWebElementText(monthlyInstallmentText, getTxtDetailsInterestRate.getText());
        compareWebElementText(totalPaymentText, txtDetailsTotalPayment.getText());
        System.out.println("Sponsor banka detaylari dogrulandi.");


    }


}

