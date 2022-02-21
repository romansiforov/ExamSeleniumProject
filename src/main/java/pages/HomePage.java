package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HeaderFooterAndNavBarPage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@id='homepage-slider']")
    private WebElement sliderHomePage;

    @FindBy(xpath = ".//*[@class='alert alert-danger']")
    private WebElement failedSubscriptionErrorText;

    @FindBy(xpath = ".//*[@class='alert alert-success']")
    private WebElement successSubscriptionText;

    @Override
    String getRelativeUrl() {
        return "/";
    }

    public HomePage openHomePage() {
        try {
            webDriver.get(baseUrl + "/");
            logger.info("Login page has been opened");
        } catch (Exception e) {
            logger.error("Can not open Login page " + e);
            Assert.fail("Can not open Login page " + e);
        }
        return this;
    }

    public HomePage checkIfRedirectedToHomePage(){
        checkUrl();
        return this;
    }

}
