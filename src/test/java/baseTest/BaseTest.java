package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

import static pages.ParentPage.configProperties;


public class BaseTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    HomePage homePage;

    @Before
    public void tearUp() {
        webDriver = initDriver();
        logger.info("------------ " + testName.getMethodName() + " was started----------");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        logger.info("Browser has been opened");
        homePage = new HomePage(webDriver);
    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser has been closed");
        logger.info("-------------- " + testName.getMethodName() + " ------------");
    }

    @Rule
    public TestName testName = new TestName();

    private WebDriver initDriver() {
        if (configProperties.testDriver().equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        }
        return webDriver;
    }
}
