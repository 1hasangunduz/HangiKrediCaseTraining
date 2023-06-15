package BasePages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVER_TL = new ThreadLocal<>();
    private static final String START_FULL_SCREEN = "--start-fullscreen";

    public static String driverType ;
    public static String getDriverType() {
        return driverType;
    }
    public static void setDriverType(String driverType) {
        DriverManager.driverType = driverType;
    }


    public static WebDriver getDriver(String browser) {
        setDriver(browser);
        return DRIVER_TL.get();
    }
    public static void setDriver(String browser) {
        WebDriver driver = null;
        switch (browser) {
            case "chrome":
                setDriverType("chrome");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--ignore-certificate-errors");
                options.addArguments("--allow-insecure-localhost");
                options.addArguments("--acceptInsecureCerts");
                options.addArguments("disable-infobars");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-gpu");
                options.addArguments("--lang=en_US");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--allowed-ips");
                options.addArguments("--disable-cache");
//                if (DriverConfig.getInstance().isChromeHeadless()) {
//                    options.addArguments("--headless");
//                } else {
//                    options.addArguments(START_FULL_SCREEN);
//                }

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                firefoxOptions.addArguments("-private-window");
                //firefoxOptions.addArguments("--headless");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "iPhone X":
            case "iPhone 6/7/8":
                setDriverType("iPhone 6/7/8");
                Map<String, String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceName", browser);

                ChromeOptions mobileOptions = new ChromeOptions();

                mobileOptions.addArguments("--incognito");
                mobileOptions.addArguments("--ignore-certificate-errors");
                mobileOptions.addArguments("--allow-insecure-localhost");
                mobileOptions.addArguments("--acceptInsecureCerts");
                mobileOptions.addArguments("disable-infobars");
                mobileOptions.addArguments("--no-sandbox");
                mobileOptions.addArguments("--disable-gpu");
                mobileOptions.addArguments("--lang=en_US");
                mobileOptions.addArguments("--remote-allow-origins=*");
                mobileOptions.addArguments("--disable-popup-blocking");
                mobileOptions.addArguments("--disable-notifications");
                mobileOptions.addArguments("--disable-extensions");
                mobileOptions.addArguments("--disable-dev-shm-usage");
                mobileOptions.addArguments("--disable-web-security");
                mobileOptions.addArguments("--disable-features=IsolateOrigins,site-per-process");
                mobileOptions.addArguments("--disable-site-isolation-trials");
                mobileOptions.addArguments("--disable-browser-side-navigation");
                mobileOptions.addArguments("--disable-infobars");
                mobileOptions.addArguments("--disable-gpu");
                mobileOptions.addArguments("--allowed-ips");
                mobileOptions.addArguments("--disable-cache");

                mobileOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

                if (DriverConfig.getInstance().isMobileHeadless()) {
                    mobileOptions.addArguments("--headless");
                } else {
                    mobileOptions.addArguments(START_FULL_SCREEN);
                }

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(mobileOptions);

                break;

            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        DRIVER_TL.set(driver);
    }

    public static WebDriver getDriver() {
        return DRIVER_TL.get();
    }
}