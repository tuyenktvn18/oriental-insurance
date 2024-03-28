package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    public static WebDriver getDriver(BrowserLists driverType) {
        switch (driverType) {
            case CHROME -> {
                return new ChromeDriver();
            }
            case FIREFOX -> {
                return new FirefoxDriver();
            }
            default -> throw new IllegalArgumentException("Invalid Driver: " + driverType);
        }
    }
}
