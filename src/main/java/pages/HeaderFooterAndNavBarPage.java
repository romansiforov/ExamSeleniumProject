package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract public class HeaderFooterAndNavBarPage extends ParentPage {

    @FindBy(xpath = ".//a[@class='login']")
    private WebElement signInButton;

    @FindBy(xpath = ".//a[@class='logout']")
    private WebElement signOutButton;

    @FindBy(xpath = ".//*[@id='setCurrency']/*[@class='current']")
    private WebElement selectCurrency;

    @FindBy(xpath = ".//*[@id='languages-block-top']/*[@class='current']")
    private WebElement selectLanguage;

    @FindBy(xpath = ".//a[@title='Contact Us']")
    private WebElement contactUsLink;

    @FindBy(xpath = ".//input[@id='newsletter-input']")
    protected WebElement newsEmailInput;

    @FindBy(xpath = ".//button[@name='submitNewsletter']")
    protected WebElement submitNewSubscriptionButton;

    public HeaderFooterAndNavBarPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void isAuthenticated() {
        elementIsVisible(signOutButton);
    }

    public void checkIfAuthenticated() {
        Assert.assertTrue("The Sign in button is not displayed", elementIsVisible(signInButton));
    }

    public AuthenticationPage clickOnSignInButton() {
        clickOnElement(signInButton);
        return new AuthenticationPage(webDriver);
    }

    public ContactUsPage clickOnContactUsButton(){
        clickOnElement(contactUsLink);
        return new ContactUsPage(webDriver);
    }

}
