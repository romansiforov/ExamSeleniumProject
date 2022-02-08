package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends ParentPage{
    @FindBy(xpath = ".//*[contains(p,'Your account has been created.')]")
    private WebElement createdAccountSuccessText;

    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "/my-account";
    }

    public MyAccountPage checkIfRedirectedToMyAccountPage(){
        Assert.assertEquals("The user isn't redirected to My Account Page",baseUrl+getRelativeUrl(),webDriver.getCurrentUrl());
        return this;
    }

    public MyAccountPage checkCreatedAccountSuccessMessage(){
        Assert.assertTrue("The success text isn't displayed", elementIsVisible(createdAccountSuccessText));
        return this;
    }
}
