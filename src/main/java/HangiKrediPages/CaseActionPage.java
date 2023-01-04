package HangiKrediPages;

import BasePages.SeleniumBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TestPage extends SeleniumBasePage {

    WebDriver driver;

    @FindBy(xpath = "//*[@class='navigation']//*[@class='has_submenu']/a[@href='/kredi']")
    WebElement btnCredit;


    public TestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void navigateToUrl(String url) {
        navigateToUrl(url);
        System.out.println(url + "Sayfasinda land olunacak.");
    }

    public void hoverCredit() {
        scrollHover(btnCredit);
        System.out.println("Kredi butonuna hover yapildi.");

    }


}
