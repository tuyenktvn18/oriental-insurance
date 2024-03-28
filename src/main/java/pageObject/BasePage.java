package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.DriverManager;

import java.time.Duration;

public class BasePage {

    private long longTimeout = 10;
    private long shortTimeout = 5;

    public void openPageUrl(String pageUrl) {
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().get(pageUrl);
    }

    public void selectItemInDefaultDropdown(By by, String textItem) {
        Select select = new Select(DriverManager.getDriver().findElement(by));
        select.selectByVisibleText(textItem);
    }

    public void waitForElementVisible(By by) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementClickable(By by) {
        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(longTimeout));
        explicitWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public By replaceStringInXpath(String str, String value) {
        return By.xpath(String.format(str, value));
    }

    public By replaceStringInCss(String str, String value) {
        return By.cssSelector(String.format(str, value));
    }

    public void clickToElement(By by) {
        DriverManager.getDriver().findElement(by).click();
    }

    public void sleepInsecond(long second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
