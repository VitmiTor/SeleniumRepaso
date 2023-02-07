package base;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import utilities.CommonFlows;
import utilities.DriverManager;
import utilities.Logs;


@Listeners({SuiteListeners.class, TestListeners.class})
public abstract class BaseTest extends DriverManager {
    private final DriverManager driverManager = new DriverManager();
    protected SoftAssert softAssert;
    protected final String smoke = "smoke";
    protected WebDriver driver;
    protected final String regression = "regression";

    protected final String browsername = "Chrome";
    //protected final DataProviders dataProvider = new DataProviders();
    protected CommonFlows commonFlows;

    @BeforeMethod(alwaysRun = true, description = "Master precondition")
    public void setUpBase() {
        softAssert = new SoftAssert();
        driver = driverManager.createDriver();
        initPages(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/");
        commonFlows = new CommonFlows(driver);
    }

    protected void setDriver(ITestResult result) {
        var currentClass = result.getInstance();
        driver = ((BaseTest) currentClass).getDriver(); //for the test listeners
    }

    @AfterMethod(alwaysRun = true, description = "Master Teardown")
    public void tearDownBase() {
        Logs.debug("Killing the driver");
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected abstract void initPages(WebDriver driver);

}