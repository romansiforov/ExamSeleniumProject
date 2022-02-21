package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends HeaderAndNavBarPage{

    @FindBy(xpath = ".//h1[text()='Authentication']")
    private WebElement authenticationTitle;

    @FindBy(xpath = ".//input[@id='email_create']")
    private WebElement createAccountEmailInput;

    @FindBy(xpath = ".//button[@id='SubmitCreate']")
    private WebElement createAccountButton;

    @FindBy(xpath = ".//input[@id='email']")
    private WebElement emailLogInInput;

    @FindBy(xpath = ".//input[@id='passwd']")
    private WebElement passwordLogInInput;

    @FindBy(xpath = ".//button[@id='SubmitLogin']")
    private WebElement signInLogInButton;

    @FindBy(xpath = ".//*[@id='create_account_error']")
    private WebElement invalidEmailErrorText;

    public AuthenticationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/authentication?back=my-account";
    }

    public AuthenticationPage checkIfAuthenticationTextDisplayed(){
        Assert.assertTrue("The Authentication title is not displayed", elementIsVisible(authenticationTitle));
        return this;
    }

    public AuthenticationPage fillEmailIntoInputCreateForm(String text){
        fillTextIntoInput(createAccountEmailInput,text);
        return this;
    }

    public RegistrationPage clickOnCreateAccountButton(){
        clickOnElement(createAccountButton);
        return new RegistrationPage(webDriver);
    }


    public  AuthenticationPage invalidEmailErrorMessageIsDisplayed(){
        elementIsVisible(invalidEmailErrorText);
        return this;
    }

    public AuthenticationPage checkErrorMessage() {
        waitForElement(invalidEmailErrorText);
        Assert.assertEquals("The error message is incorrect", "Invalid email address.",invalidEmailErrorText.getText());
        return this;
    }

    public AuthenticationPage clickOnCreateAccountButtonNegativeTransition() {
        clickOnElement(createAccountButton);
        return this;
    }
}
