package FolderTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    // open connection local
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<>();

    //Annotation
    //Before (Open Browser, Additional Open Website or url)
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();

        // Getter and Setter untuk buka browser dan url
        driver.set(new FirefoxDriver(options));
        driver.get().manage().window().maximize();// maximize window
        driver.get().get("https://www.demoblaze.com/");
        explicitWait.set(new WebDriverWait((driver.get()), Duration.ofSeconds(120)));
    }

    //After (Close Browser atau close connection)
    @AfterMethod
    public void closeBrowser(){
        driver.get().quit();
    }
}
