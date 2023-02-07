package webElements.single;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class $ {
    private By locator;
    private final WebDriver driver;
    private WebElement webElement;
    private final int defaulTimeOut = 5;
    private WebDriverWait wait;
    private boolean search = true;

    public $(By locator, WebDriver driver) {
        this.locator = locator;
        this.driver = driver;
    }

    public $(WebElement webElement, WebDriver driver) {
        this.webElement = webElement;
        this.driver = driver;
        this.search = false;
    }

    public $ click() {
        findElement();
        webElement.click();
        return this;
    }


    public $ sendKeys(String text) {
        findElement();
        webElement.sendKeys(text);
        return this;
    }


    public $ clear() {
        findElement();
        webElement.clear();
        return this;
    }

    public boolean isDisplayed() {
        findElement();
        return webElement.isDisplayed();
    }


    public boolean isEnable() {
        findElement();
        return webElement.isEnabled();
    }


    public boolean isSelected() {
        return webElement.isSelected();
    }

    public String getText() {
        findElement();
        return webElement.getText();
    }

    public String getHref() {
        findElement();
        return webElement.getAttribute("href");
    }

    public void selectByValue(String value) {
        getSelect().selectByValue(value);
    }

    public void selectByVisisbleText(String Text) {
        getSelect().selectByVisibleText(Text);
    }

    public void slectByIndex(int index) {
        getSelect().deselectByIndex(index);
    }

    public void deselectByValue(String value) {
        getSelect().deselectByValue(value);
    }

    public void deselectByVisisbleText(String Text) {
        getSelect().deselectByVisibleText(Text);
    }

    public void deslectByIndex(int index) {
        getSelect().deselectByIndex(index);
    }

    public $ waitForVisibility() {
        createWait(defaulTimeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    public $ waitForVisibility(int timeOut) {
        createWait(timeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this;
    }

    private Select getSelect() {
        findElement();
        return new Select(webElement);
    }

    private void findElement() {
        if (search) {
            webElement = driver.findElement(locator);
        }
    }

    private void createWait(int timeOut) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
    }
}
