package pages;

import libs.TestData;
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

    public HomePage fillEmailIntoNewsSubscriptionInput(String email){
        fillTextIntoInput(newsEmailInput,email);
        return this;
    }

    public HomePage clickOnSubmitSubscriptionButton(){
        clickOnElement(submitNewSubscriptionButton);
        return this;
    }

    public HomePage checkIfSuccessMessageVisible() {
        elementIsVisible(successSubscriptionText);
        return this;
    }

    public HomePage checkIfFailureMessageVisible(){
        elementIsVisible(failedSubscriptionErrorText);
        return this;
    }

    public HomePage checkIfSuccessMessageCorrectness() {
        Assert.assertEquals("The success message is incorrect", TestData.VALID_SUCCESS_SUBSCRIPTION_TEXT, successSubscriptionText.getText().trim());
        return this;
    }

    public HomePage checkIfFailureMessageCorrectness() {
        Assert.assertEquals("The success message is incorrect", TestData.VALID_SUCCESS_SUBSCRIPTION_TEXT, successSubscriptionText.getText().trim());
        return this;
    }
}
