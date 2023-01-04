package BasePages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import java.util.Random;

import static io.restassured.RestAssured.given;

public class SeleniumBasePage {

    Actions actions = new Actions(DriverManager.getDriver());

    public void scrollHover(WebElement element, String message) {
        actions.moveToElement(element).build().perform();
        System.out.println(message);
    }

    public void postRequest(String url) {
        Response response = given()
                .header("Content-type", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .post(url)
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().response();
        System.out.println("Status Code --> " + response.statusCode());
    }

    public int generateNumbers(int min, int max) {
        Random random = new Random();
        int randomInt = random.nextInt((max - min) + 1) + min;
        return randomInt;
    }

    public void selectCombobox(WebElement element, String value) {

        String elemText = null;
        try {
            elemText = element.getText();
            Select selectBox = new Select(element);
            selectBox.selectByValue(value);
            System.out.println("Value : " + value + " - SelectComboBox : " + elemText);
        } catch (Exception e) {
            System.err.println("combobox value -> " + value);
        }
    }

    public void compareWebElementText(String text1, String text2) {
        if (text1.equals(text2)) System.out.println(text1 + " ve " + text2 + "' yi karsilastirma basarili ve herhangi bir hata yoktur.");
        else System.err.println("Karsilastirma basarisiz, lütfen kontrol ediniz.");
    }
}
