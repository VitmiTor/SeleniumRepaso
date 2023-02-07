package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.Logs;
import webElements.list.$$;
import webElements.single.$;

public abstract class BasePage {
    protected final WebDriver driver;
    private int timeOut;
    protected SoftAssert softAssert;
    private final int defaultTimaOut = 5;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.timeOut = defaultTimaOut;
        softAssert = new SoftAssert();
    }

    protected void waitPage($ element, String pageName) {
        var message = String.format("Waiting %s page to load ", pageName);
        Logs.info(message);
        element.waitForVisibility(timeOut);

        message = String.format("%s loaded successfully ", pageName);
        Logs.info(message);
    }

    protected $ $(By locator) {
        return new $(locator, driver);
    }

    protected $$ $$(By locator) {
        return new $$(locator, driver);
    }

    public abstract void waitPageToLoad();

    public abstract void verifyPage();
}
