package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import pageObject.GetQuotePage;
import webdriver.BrowserLists;
import webdriver.Driver;
import webdriver.DriverManager;

public class TestContext {
    private WebDriver driver;

    public TestContext() {
        driver = Driver.getDriver(BrowserLists.CHROME);
        DriverManager.setDriver(driver);
    }

    private GetQuotePage getQuotePage;

    public GetQuotePage getQuotePage() {
        return getQuotePage = getQuotePage == null ? new GetQuotePage() : getQuotePage;
    }

}
