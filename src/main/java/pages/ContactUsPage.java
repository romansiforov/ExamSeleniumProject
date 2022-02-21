package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends ParentPage{

    @FindBy(xpath = ".//input[@id='email']")
    private WebElement emailInputContactUsForm;

    @FindBy(xpath = ".//textarea[@id='message']")
    private WebElement messageTextAreaContactUsForm;

    @FindBy(xpath = ".//select[@id='id_contact']")
    private WebElement subjectHeadingSelectContactUsForm;

    @FindBy(xpath = ".//button[@name='submitMessage']")
    private WebElement sendMessageButton;

    @FindBy(xpath = ".//*[@class='alert alert-success']")
    private WebElement contactMessageHasBeenSentSuccessText;

    public ContactUsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/contact-us";
    }

    public ContactUsPage fillEmailIntoInput(String email){
        fillTextIntoInput(emailInputContactUsForm, email);
        return this;
    }

    public ContactUsPage fillMessageTextArea(String message){
        fillTextIntoInput(messageTextAreaContactUsForm,message);
        return this;
    }

    public ContactUsPage clickOnSendMessageButton(){
        clickOnElement(sendMessageButton);
        return this;
    }

    public ContactUsPage selectItemFromTheSubjectHeading(String item){
        selectElementFromSelect(subjectHeadingSelectContactUsForm, item);
        return this;
    }

    public ContactUsPage checkIfSuccessTextVisible(){
        elementIsVisible(contactMessageHasBeenSentSuccessText);
        return this;
    }

    public ContactUsPage checkIfRedirectedToContactUsPage() {
        checkUrl();
        return this;
    }
}
