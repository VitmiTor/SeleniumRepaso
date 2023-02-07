package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

    public WebDriver createDriver() {
        var browserName = System.getProperty("browser");
        if (browserName == null) {
            Logs.debug("Setting default local browser to Chrome");
            browserName = "Chrome";
        }
        WebDriver driver;
        switch (browserName) {
            case "Chrome":
                Logs.debug("Initializing Edge driver");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Edge":
                Logs.debug("Initializing Edge driver");
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "Safari":
                Logs.debug("Initializing Safari driver");
                WebDriverManager.safaridriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                return null;
        }

        Logs.debug("Initializing the driver");
        WebDriverManager.chromedriver().setup();
        Logs.debug("Maximizando Windows");
        driver.manage().window().maximize();
        Logs.debug("Eliminado cookies");
        driver.manage().deleteAllCookies();
        FileManager.staticDriver = driver;

        return driver;
    }
}