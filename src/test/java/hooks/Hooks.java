package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import webdriver.BrowserLists;
import webdriver.Driver;
import webdriver.DriverManager;

import java.util.Objects;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @After
    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
