package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.safari.SafariDriver;

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
                final var chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "Edge":
                Logs.debug("Initializing Edge driver");
                WebDriverManager.edgedriver().setup();
                final var edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "Safari":
                Logs.debug("Initializing Safari driver");
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
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