package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class RegistrationPage extends HeaderFooterAndNavBarPage {

    @FindBy(xpath = ".//input[@id='customer_firstname']")
    private WebElement firstNameCreateAccountForm;

    @FindBy(xpath = "")
    private WebElement CreateAccountForm;

    @FindBy(xpath = ".//input[@id='customer_lastname']")
    private WebElement lastNameCreateAccountForm;

    @FindBy(xpath = ".//input[@id='email']")
    private WebElement emailCreateAccountForm;

    @FindBy(xpath = ".//input[@id='passwd']")
    private WebElement passwordCreateAccountForm;

    @FindBy(xpath = ".//select[@id='days']")
    private WebElement dayOfBirthSelectCreateAccountForm;

    @FindBy(xpath = ".//select[@id='months']")
    private WebElement monthOfBirthSelectCreateAccountForm;

    @FindBy(xpath = ".//*[@id='cuselFrame-years']")
    private WebElement YearOfBirthSelectCreateAccountForm;

    @FindBy(xpath = ".//input[@id='newsletter']")
    private WebElement newsSubscriptionCheckBoxCreateAccountForm;

    @FindBy(xpath = ".//input[@id='optin']")
    private WebElement specialOffersCheckBoxCreateAccountForm;

    @FindBy(xpath = ".//*[@class='radio']")
    private WebElement sexCreateAccountForm;

    @FindBy(xpath = ".//button[@name='submitAccount']")
    private WebElement registerButton;

    @FindBy(xpath = ".//input[@id='id_gender1']")
    private WebElement maleRadioButton;

    @FindBy(xpath = ".//*[@style='display: block;']/h1")
    private WebElement createAccountForm;


    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/en/authentication?back=my-account#account-creation";
    }

    public RegistrationPage fillFirstNameIntoInput(String firstName) {
        fillTextIntoInput(firstNameCreateAccountForm, firstName);
        return this;
    }

    public RegistrationPage fillLastNameIntoInput(String lastName) {
        fillTextIntoInput(lastNameCreateAccountForm, lastName);
        return this;
    }

    public RegistrationPage fillEmailIntoInput(String email) {
        fillTextIntoInput(emailCreateAccountForm, email);
        return this;
    }

    public RegistrationPage fillPasswordIntoInput(String password) {
        fillTextIntoInput(passwordCreateAccountForm, password);
        return this;
    }

    public RegistrationPage selectDayOfBirth(int day) {
        selectValue(dayOfBirthSelectCreateAccountForm, String.valueOf(day));
        return this;
    }

    public RegistrationPage selectMonthOfBirth(String month) {
        selectValue(monthOfBirthSelectCreateAccountForm, month);
        return this;
    }

    public RegistrationPage selectYearOfBirth(int year) {
        selectValue(dayOfBirthSelectCreateAccountForm, String.valueOf(year));
        return this;
    }

    public RegistrationPage checkNewsSignificationCheckBox() {
        checkTheCheckBox(newsSubscriptionCheckBoxCreateAccountForm);
        return this;
    }

    public RegistrationPage checkSpecialOffersCheckBox() {
        checkTheCheckBox(specialOffersCheckBoxCreateAccountForm);
        return this;
    }

    //TO DO
    public RegistrationPage setGender(Gender gender) {
        return this;
    }

    public MyAccountPage clickRegisterButton() {
        clickOnElement(registerButton);
        return new MyAccountPage(webDriver);
    }

    public RegistrationPage checkIfRedirectedToRegistrationPage() {
        waitForElement(createAccountForm);
        Assert.assertEquals("The user hasn't been redirected to the Registration Page",baseUrl+getRelativeUrl(),webDriver.getCurrentUrl());
        return this;
    }

}
