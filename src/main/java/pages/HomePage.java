package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HeaderAndNavBarPage{
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@id='homepage-slider']")
    private WebElement sliderHomePage;

    @Override
    String getRelativeUrl() {
        return "/";
    }
}
